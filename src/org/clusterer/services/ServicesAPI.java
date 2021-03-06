package org.clusterer.services;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.clusterer.edgebundles.io.DataReader;
import org.clusterer.edgebundles.io.HEBServiceAdapter;
import org.clusterer.services.response.VisualTreeResponse;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;


@Controller
@EnableAutoConfiguration
@RequestMapping("/ServiceClusterer")
public class ServicesAPI //extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private List<MultipartFile> listFiles;
	private List<String> listFileNames;
	private static int BOTTHRESHOLD = 30;   
	private static int TOPTHRESHOLD = 80;
	private static String CLUSTERING_STRATEGY = "";
	private static Integer CLUSTER_COUNT = 0;
	private static boolean DO_WSDL_CLUSTERING = true;
	private static String WSDL_CLUSTERING_STRATEGY = "";
	private static boolean SPLIT_TERMS = true;
	private static ArrayList<String> BLACKLIST;
	private static int FILTER_TERMS_SIZE = 2;
	private static int WSDL_CLUSTER_COUNT = 2;
	private static boolean DO_FILTERING = true;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//	@Override
	@RequestMapping(value = "check", method = RequestMethod.GET)
	protected void checkService(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
			IOException
	{
		final PrintWriter out = response.getWriter();
		out.println("Service Running!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//@Override

	@RequestMapping(value = "visualtree", method = RequestMethod.POST)
	protected void treeGeneratorService(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException
	{

		listFiles = new ArrayList<MultipartFile>();
		listFileNames = new ArrayList<String>();
		final MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;

		BOTTHRESHOLD = Integer.parseInt(request.getParameter("files[bottomsimil]"));
		TOPTHRESHOLD = Integer.parseInt(request.getParameter("files[topsimil]"));
		CLUSTERING_STRATEGY = request.getParameter("files[clusteringstrategy]");
		CLUSTER_COUNT = Integer.parseInt(request.getParameter("files[numberofclusters]"));
		DO_WSDL_CLUSTERING = Boolean.parseBoolean(request.getParameter("files[dowsdlclustering]"));
		WSDL_CLUSTERING_STRATEGY = request.getParameter("files[wsdlclusteringstrategy]");
		final Iterator<String> itr = mRequest.getFileNames();
		while (itr.hasNext())
		{
			final MultipartFile mFile = mRequest.getFile(itr.next());
			final String fileName = mFile.getOriginalFilename();
			listFiles.add(mFile);
			listFileNames.add(fileName);
			System.out.println(fileName);
		}
		final DataReader data = new HEBServiceAdapter(listFiles, BOTTHRESHOLD / 100.0, TOPTHRESHOLD / 100.0, CLUSTERING_STRATEGY,
				CLUSTER_COUNT, DO_WSDL_CLUSTERING, WSDL_CLUSTERING_STRATEGY, SPLIT_TERMS, BLACKLIST, FILTER_TERMS_SIZE, DO_FILTERING, WSDL_CLUSTER_COUNT);

		final String jsonTreeMap = createJsonTreeData(data);
		final String jsonFileMap = createJsonMapData(data);
		final PrintWriter out = response.getWriter();
		out.println(jsonTreeMap);
		out.println(jsonFileMap);
		out.println(data.getNumberOfClusters());
		out.println(data.getValidationInfo());
		out.println(listFiles.size());

		for (final MultipartFile mFile : listFiles)
		{
			final String fileName = mFile.getOriginalFilename();
			mFile.transferTo(new File("/tmp/" + fileName));
		}
	}

	private String createJsonMapData(final DataReader jsonData)
	{
		final AbstractMap<String, String> mapFiles = jsonData.getMapParentFile();
		final Gson g = new Gson();
		final String jsonResult = g.toJson(mapFiles);
		return jsonResult;
	}

	private String createJsonTreeData(final DataReader jsonData)
	{
		final int parents[] = jsonData.getParents();
		final int adjacencyList[][] = jsonData.getAdjacencyList();
		final Hashtable<Integer, Integer> parentsMap = new Hashtable<Integer, Integer>();
		final AbstractMap<Integer, String> namesMap = jsonData.getNamesMap();
		final List<VisualTreeResponse> arrayResult = new ArrayList<VisualTreeResponse>();
		final int countNodes = jsonData.getNodesCount();
		for (int i = 2; i < countNodes; i++)
		{
			parentsMap.put(i + 1, parents[i] + 1);
		}
		for (int i = 2; i < countNodes; i++)
		{
			if (parents[i] > 0)
			{

				final String nameKey = doName(parents[i], i);
				final String name = namesMap.get(i);
				final String[] imports = doImports(adjacencyList[i], parentsMap);
				final VisualTreeResponse r = new VisualTreeResponse(nameKey, name, imports);
				arrayResult.add(r);
			}
		}
		final Gson g = new Gson();
		final String jsonResult = g.toJson(arrayResult);
		return jsonResult;
	}

	private String doName(final int parentName, final int nodeName)
	{
		final String p = String.valueOf(parentName + 1);
		final String n = String.valueOf(nodeName + 1);
		return p + '.' + n;
	}

	private String[] doImports(final int[] adj, final Hashtable<Integer, Integer> parentsMap)
	{
		if (adj.length == 0)
		{
			final String t[] = new String[0];
			return t;
		}
		else
		{
			final int l = adj.length;
			final String[] r = new String[l];
			for (int i = 0; i < l; i++)
			{
				r[i] = String.valueOf(parentsMap.get(adj[i] + 1)) + "." + String.valueOf(adj[i] + 1);
			}
			return r;
		}
	}

	public List<String> getListFileNames()
	{
		return listFileNames;
	}

	public List<MultipartFile> getListFiles()
	{
		return listFiles;
	}

}
