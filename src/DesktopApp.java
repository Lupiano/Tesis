import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.ow2.easywsdl.wsdl.api.Operation;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.cuny.qc.speech.ClusterEvaluator;
import edu.cuny.qc.speech.ContingencyTable;

import com.google.gson.Gson;

public class DesktopApp {
	
	private static final long serialVersionUID = 1L;
	private final File folder = new File("dataset");
	private List<MultipartFile> listFiles;
	private List<String> listFileNames;
	private static int BOTTHRESHOLD = 30;
	private static int TOPTHRESHOLD = 80;
	private static String CLUSTERING_STRATEGY = "kmeans";
	private static Integer CLUSTER_COUNT = 32;
	
	public ArrayList<ArrayList<String>> operations = new ArrayList<ArrayList<String>>();


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
				CLUSTER_COUNT);
		
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
		System.out.println(jsonTreeMap);
		System.out.println(jsonFileMap);
		System.out.println(data.getNumberOfClusters());
		System.out.println(data.getValidationInfo());
		System.out.println(listFiles.size());

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


	public static void main(String[] args) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("output.txt"))));
		
		DesktopApp app = new DesktopApp();
		
		app.treeGenerator();
		
		ArrayList<ArrayList<String>> clusters = app.getOperations();
		
		casoManualPreFijosImeroni casoManual = new casoManualPreFijosImeroni();
		
		casoManual.cargarListas();
		
		ArrayList<RefactorizacionManual> refManual = (ArrayList<RefactorizacionManual>)casoManual.getCasosManuales();
		
		ArrayList<Clase> clases = (ArrayList<Clase>)refManual.get(0).getClases();
		
		System.out.println("Cantidad de clusters: " + clusters.size());
		System.out.println("Cantidad de clases: " + clases.size());

		

		ComparadorClusterClase comparador = new ComparadorClusterClase();
		comparador.setMetodoOcurrencia(new MetodoOcurrenciaSinRep());
		
		Double[][] data = new Double[clusters.size()][clases.size()];
		
		ContingencyTable contingencyTable = new ContingencyTable(clusters.size(),clases.size());
		
		for(int i=0; i<clusters.size(); i++) {
			for(int j=0; j<clases.size(); j++) {
				data[i][j] = comparador.obtenerIntersecciones(clusters.get(i), (ArrayList<String>)clases.get(j).getOperaciones());
				contingencyTable.set(i, j, data[i][j]);
			}
		}
		
		for(int i=0; i<clusters.size(); i++) {
			System.out.println("");
			for(int j=0; j<clases.size(); j++) {
				System.out.print(" " + data[i][j]);			
			}
		}
		System.out.println("");
		System.out.println("Contingency: "+ contingencyTable.toString());
		
		
		ClusterEvaluator eval = new ClusterEvaluator();
		
		
		eval.setData(contingencyTable);
		
		System.out.println("Solucion:");
		System.out.println(eval.getVMeasure(1));

		
		//System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("output1.txt"))));
		System.out.println("Termina.");
		
	}

}
