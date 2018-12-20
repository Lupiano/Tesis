package org.clusterer.app;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.ow2.easywsdl.wsdl.api.Operation;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.cuny.qc.speech.ClusterEvaluator;
import edu.cuny.qc.speech.ContingencyTable;

import com.google.gson.Gson;

public class ClusteringDesktopApp {
	
	private static final long serialVersionUID = 1L;
	private final File folder = new File("dataset");
	private List<MultipartFile> listFiles;
	private List<String> listFileNames;
	private int BOTTHRESHOLD = 30;
	private int TOPTHRESHOLD = 80;
	
	private String CLUSTERING_STRATEGY;
	private Integer CLUSTER_COUNT;
	
	//Configuración mejoras.
	private boolean SPLIT_TERMS;
	private boolean DO_FILTERING;
	private ArrayList<String> BLACKLIST = new ArrayList<String>();
	private int FILTER_TERMS_SIZE;
	
	//División nivel WSDL.
	private boolean DO_WSDL_CLUSTERING;
	private String WSDL_CLUSTERING_STRATEGY;
	private int WSDL_CLUSTER_COUNT;
	
	public ArrayList<ArrayList<String>> operations = new ArrayList<ArrayList<String>>();
	
	public ClusteringDesktopApp(JSONObject configJSON) {
		
		CLUSTERING_STRATEGY = (String)configJSON.get("clustering_strategy");
		CLUSTER_COUNT = (int)(long)configJSON.get("cluster_count");
		SPLIT_TERMS = (Boolean)configJSON.get("split_terms");
		DO_FILTERING = (Boolean)configJSON.get("do_filtering");
		FILTER_TERMS_SIZE = (int)(long)configJSON.get("filter_terms_size");
		DO_WSDL_CLUSTERING = (Boolean)configJSON.get("do_wsdl_clustering");
		WSDL_CLUSTERING_STRATEGY = (String)configJSON.get("wsdl_clustering_strategy");
		WSDL_CLUSTER_COUNT = (int)(long)configJSON.get("wsdl_cluster_count");
        BLACKLIST = (ArrayList<String>) configJSON.get("blacklist");

		
		BLACKLIST.add("tipo");
		BLACKLIST.add("codigo");
		BLACKLIST.add("numero");
		BLACKLIST.add("desde");
		BLACKLIST.add("hasta");
		BLACKLIST.add("nro");
		BLACKLIST.add("ing");
		BLACKLIST.add("sin");
		BLACKLIST.add("con");
		BLACKLIST.add("dar");
		BLACKLIST.add("para");
		BLACKLIST.add("otros");
		BLACKLIST.add("propio");
		BLACKLIST.add("entre");
		BLACKLIST.add("comp");
		BLACKLIST.add("segun");
	}


	public ArrayList<ArrayList<String>> getOperations() {
		return operations;
	}


	public void setOperations(ArrayList<ArrayList<String>> operations) {
		this.operations = operations;
	}


	protected void treeGenerator()
			throws ServletException, IOException
	{

		listFiles = new ArrayList<MultipartFile>();
		listFileNames = new ArrayList<String>();
		
		
		/*
		final MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		BOTTHRESHOLD = Integer.parseInt(request.getParameter("files[bottomsimil]"));
		TOPTHRESHOLD = Integer.parseInt(request.getParameter("files[topsimil]"));
		CLUSTERING_STRATEGY = request.getParameter("files[clusteringstrategy]");
		CLUSTER_COUNT = Integer.parseInt(request.getParameter("files[numberofclusters]"));
		*/

		listFiles = getMultipartFilesFromFolder(folder);
		for(MultipartFile mFile: listFiles)
		{
			String fileName = mFile.getOriginalFilename();
			listFileNames.add(fileName);
			//System.out.println(fileName);
		}
		final DataReader data = new HEBServiceAdapter(listFiles, BOTTHRESHOLD / 100.0, TOPTHRESHOLD / 100.0, CLUSTERING_STRATEGY,
				CLUSTER_COUNT, DO_WSDL_CLUSTERING, WSDL_CLUSTERING_STRATEGY, SPLIT_TERMS, BLACKLIST, FILTER_TERMS_SIZE, DO_FILTERING, WSDL_CLUSTER_COUNT);
		
		ArrayList<ArrayList<Operation>> clusteredOperations = data.getClusteredOperations();
		
		
		for (ArrayList<Operation> opList: clusteredOperations)
		{
			operations.add(parsedStringOperationList(opList));
		}
		
		System.out.println("Operaciones en string");
		
		System.out.println(operations.toString());
		
		final String jsonTreeMap = createJsonTreeData(data);
		final String jsonFileMap = createJsonMapData(data);
		//final PrintWriter out = response.getWriter();
		
		//System.out.println(jsonTreeMap);
		//System.out.println(jsonFileMap);
		//System.out.println(data.getNumberOfClusters());
		//System.out.println(data.getValidationInfo());
		//System.out.println(listFiles.size());

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
	
	private ArrayList<MultipartFile> getMultipartFilesFromFolder(final File folder) {
		ArrayList<MultipartFile> files = new ArrayList<MultipartFile>();
	    for (final File fileEntry : folder.listFiles()) {
	        	Path path = Paths.get(fileEntry.getPath());
	        	String name = fileEntry.getName();
	        	String contentType = "text/plain";
	        	byte[] content = null;
	        	try {
	        	    content = Files.readAllBytes(path);
	        	} catch (final IOException e) {
	        	}
	        	MultipartFile result = new MockMultipartFile(name,
	                     name, contentType, content);
            files.add(result);
	    }
	    files.sort(new Comparator<MultipartFile>() {

			@Override
			public int compare(MultipartFile o1, MultipartFile o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}

	    	
	    });
	    return files;
	}
	
	private ArrayList<String> parsedStringOperationList(ArrayList<Operation> opList){
		ArrayList<String> aux = new ArrayList<String>();
		for(Operation op: opList) {
			aux.add(parseOperation(op));
		}
		return aux;
	}

	private String parseOperation(Operation op) {
		String opName = op.getQName().toString();
		return opName.substring(31, opName.length());
	}


	public static void main(String[] args) throws IOException {
		
		JSONParser parser = new JSONParser();
		JSONObject configJSON = new JSONObject();
		try {

			configJSON = (JSONObject)parser.parse(new FileReader("config.json"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		try {
			
		
			ClusteringDesktopApp app = new ClusteringDesktopApp(configJSON);
			
			app.treeGenerator();
			
			String nombreRefManual = (String)configJSON.get("manual_refactoring");
			ArrayList<ArrayList<String>> clusters = app.getOperations();
			
			CasoManual casoManual = new CasoManual();
			//A, B o C
			String fRefManual = "config/" + nombreRefManual;
			ArrayList<RefactorizacionManual> refManual = (ArrayList<RefactorizacionManual>)casoManual.getCasoManualJSON(fRefManual);
			
			
			ArrayList<Clase> clases = (ArrayList<Clase>)refManual.get(0).getClases();
			
			System.out.println("Cantidad de clusters: " + clusters.size());
			System.out.println("Cantidad de clases: " + clases.size());
	
			ComparadorClusterClase comparador = new ComparadorClusterClase();
			comparador.setMetodoOcurrencia(new MetodoOcurrenciaSinRep());
			
			//Prueba.
			ClusterEvaluator eval = new ClusterEvaluator();
			
			Double[][] data = new Double[2][2];
	
		    data[0][0] = 1.0;
		    data[0][1] = 1.0;
		    data[1][0] = 1.0;
		    data[1][1] = 0.0;
			
			Double[][] data1 = new Double[clusters.size()][clases.size()];
			for(int i=0; i<clusters.size(); i++) {
				for(int j=0; j<clases.size(); j++) {
					data1[i][j] = comparador.obtenerIntersecciones(clusters.get(i), (ArrayList<String>)clases.get(j).getOperaciones());
				}
			}
			
		    eval.setData(new ContingencyTable(data1));
		    
		    System.out.println("Solution A");
		    //System.out.println(eval.getData());
		    System.out.println("V:" + eval.getVMeasure(1));
		    
		    PrintWriter writer = new PrintWriter("results.txt", "UTF-8");
		    writer.println("Cantidad de clusters: " + clusters.size());
		    writer.println("Cantidad de clases: " + clases.size());
		    writer.println("");
		    writer.println("Distancia V-Measure: " + eval.getVMeasure(1));
		    writer.close();
	    
		}
		catch(Exception e){
			FileWriter fw = new FileWriter("error_logs.txt",true);
			PrintWriter writer = new PrintWriter(fw);
			Date now = new Date();
			writer.println("");
			writer.println("");
			writer.print(now + ": ");
			e.printStackTrace (writer);
			writer.close();
		}

	}

}
