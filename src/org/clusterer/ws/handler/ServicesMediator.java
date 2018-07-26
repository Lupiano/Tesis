package org.clusterer.ws.handler;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.json.JSONObject;

import org.clusterer.distance.JaccardDistance;
import org.clusterer.strategy.ClusteringStrategy;
import org.clusterer.strategy.StrategyConstructor;
import org.clusterer.strategy.XmeansStrategy;
import org.clusterer.util.Pair;
import org.ow2.easywsdl.wsdl.api.Description;
import org.ow2.easywsdl.wsdl.api.Operation;
import org.springframework.web.multipart.MultipartFile;


public class ServicesMediator
{

	//private AbstractMap <String,Integer> mapOps= new HashMap<String,Integer>();
	private final ClusteringHandler ch;
	private final OperarionSimilarityHandler osh;
	private final List<MultipartFile> listFiles;
	private Integer clusterNumber;
	private JSONObject validationInfo;
	private HashMap<String, Object> clusteredInfo;
	AbstractMap<Pair, Double> relatedOperations;
	private final double topThreshold;
	private final double bottomThreshold;
	private String clusteringStrategy;

	//Agregado Luciano - Brian
	private boolean doWSDLClustering;
	private String wsdlClusteringStrategy;
	private boolean splitTerms;
	private boolean doFiltering;
	private ArrayList<String> blacklist;
	private int wsdlClusterNumber;
	private int filterTermsSize;

	public ServicesMediator(final List<MultipartFile> listFiles, final double botThreshold, final double topThreshold)
	{
		this.topThreshold = topThreshold;
		this.bottomThreshold = botThreshold;
		this.listFiles = listFiles;
		ch = new ClusteringHandler();
		osh = new OperarionSimilarityHandler();


	}

	private void doClustering() throws Exception
	{
		ArrayList<List<MultipartFile>> wsdlClusters = new ArrayList<List<MultipartFile>>();
		
		wsdlClusters.add((ArrayList<MultipartFile>)listFiles);
		
		
		//Agregado Luciano - Brian.
		//Agrupar a nivel WSDL si es true
		if(getDoWSDLClustering()) {
			ClusteringStrategy wsdlStrategy = StrategyConstructor.getWsdlStrategy(getWsdlClusteringStrategy(), getWsdlClusterNumber());
			ClusteringHandler chWSDL = new ClusteringHandler();
			chWSDL.setClustererStrategy(wsdlStrategy);
			wsdlClusters = chWSDL.clusterWSDL(listFiles, splitTerms, doFiltering, filterTermsSize, blacklist);
			
			System.out.println("Total WSDL Clusters: " + wsdlClusters.size());
		}
		

		//Si no se hace la división a nivel WSDL, wsdlClusters tiene un solo cluster WSDL con los archivos iniciales.
		ClusteringStrategy strategy = null;
		
		List<List<Operation>> totalClusters = new ArrayList<List<Operation>>();
		int k = 0;
		for(List<MultipartFile> list : wsdlClusters) {
			strategy = StrategyConstructor.getStrategy(getClusteringStrategy(), getClusterNumber());
			strategy.setThreshold(topThreshold);
			ch.setClustererStrategy(strategy);
			System.out.println("");
			System.out.println("WSDL Cluster " + k);
			@SuppressWarnings("unchecked")
			List<List<Operation>> aux = (List<List<Operation>>)ch.clusterWSDLDocumentsForCluster(list, splitTerms, doFiltering, filterTermsSize, blacklist, topThreshold).get("clusterOperations");
			
			totalClusters.addAll(aux);
			k++;
		}
		
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("");
		
		System.out.println("Total WSDL Clusters: " + wsdlClusters.size());
		k = 0;
		for(List<MultipartFile> list : wsdlClusters) {
			ClusteringHandler handler = new ClusteringHandler();
			handler.setClustererStrategy(strategy);
			//@SuppressWarnings("unchecked")
			System.out.println("WSDL Cluster " + k + " (" + list.size() + " wsdls)");
			k++;
		}
		
		System.out.println("");
		System.out.println("Total clusters finales: " + totalClusters.size());
		
		for(int x=0; x<totalClusters.size(); x++) {
			System.out.println("Cluster " + x + " (" + totalClusters.get(x).size() + " operaciones)");
		}
		
		clusteredInfo = new HashMap<String, Object>();
		
		clusteredInfo.put("clusterOperations", totalClusters);
		
		/*
		@SuppressWarnings("unchecked")
		final List<List<Operation>> clusteredOperations = (List<List<Operation>>) clusteredInfo.get("clusterOperations");
		System.out.println("Cantidad de Grupos> " + clusteredOperations.size() + "threshold:" + topThreshold);
		int inum = 0;
		List<Operation> lo;
		
		int cantidadTotal = 0;

		for (final Iterator<List<Operation>> i = clusteredOperations.iterator(); i.hasNext(); inum++)
		{
			lo = i.next();
			System.out.println("Grupo: " + inum + " cant op: " + lo.size());
			System.out.println("ops: " + lo.toString());
			System.out.println("**************************************");
			cantidadTotal += lo.size();
		}
		
		System.out.println("El total es: " + cantidadTotal);
		

		setClusterNumber(inum++);
		setValidationInfo(strategy.validateCluster());
		*/
	}

	private void doSimilRelations()
	{
		relatedOperations = osh.generateOperationSimilarity(listFiles, 10, bottomThreshold, topThreshold);

		//System.out.println("Relaciones entre operaciones");
		for (final Iterator<Entry<Pair, Double>> i = relatedOperations.entrySet().iterator(); i.hasNext();)
		{
			final Entry<Pair, Double> ent = i.next();
			//System.out.println("Par " + ent.getKey().getLeft() + " : " + ent.getKey().getRight() + " : " + ent.getValue());

		}

		//System.out.println("Relaciones entre operaciones adyacentes: ");
		for (final Iterator<Entry<String, Set<String>>> i = osh.getOpSimilSet().entrySet().iterator(); i.hasNext();)
		{
			final Entry<String, Set<String>> ent = i.next();
			//System.out.println("Par ad " + ent.getKey() + " links: " + ent.getValue());
		}
	}

	public void doAllInferences()
	{
		try
		{
			doClustering();
		}
		catch (final Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doSimilRelations();
	}

	public HashMap<String, Object> getClusteredOperations()
	{
		return clusteredInfo;
	}

	public AbstractMap<Pair, Double> getRelatedOperations()
	{
		return relatedOperations;
	}

	public AbstractMap<Operation, Description> getFileDescriptions()
	{
		return ch.getFileDescriptions();
	}

	public Description getOperationURL(final Operation o)
	{
		return getFileDescriptions().get(o);
	}

	public Double getLinkValue(final Pair p)
	{
		return relatedOperations.get(p);
	}

	public Set<String> getRelatedOperations(final String op)
	{
		return osh.getOpSimilSet().get(op);
	}

	public Integer getClusterNumber()
	{
		return clusterNumber;
	}

	public void setWsdlClusterNumber(final Integer clusterNumber)
	{
		this.wsdlClusterNumber = clusterNumber;
	}
	
	public Integer getWsdlClusterNumber()
	{
		return wsdlClusterNumber;
	}

	public void setClusterNumber(final Integer clusterNumber)
	{
		this.clusterNumber = clusterNumber;
	}

	public String getClusteringStrategy()
	{
		return clusteringStrategy;
	}

	public void setClusteringStrategy(final String clusteringStrategy)
	{
		this.clusteringStrategy = clusteringStrategy;
	}

	public JSONObject getValidationInfo()
	{
		return validationInfo;
	}

	public void setValidationInfo(final JSONObject validationInfo)
	{
		this.validationInfo = validationInfo;
	}

	public boolean getDoWSDLClustering() {
		return doWSDLClustering;
	}

	public void setDoWSDLClustering(boolean doWSDLClustering) {
		this.doWSDLClustering = doWSDLClustering;
	}
	
	public String getWsdlClusteringStrategy() {
		return wsdlClusteringStrategy;
	}

	public void setWsdlClusteringStrategy(String wsdlClusteringStrategy) {
		this.wsdlClusteringStrategy = wsdlClusteringStrategy;
	}

	public boolean isSplitTerms() {
		return splitTerms;
	}

	public void setSplitTerms(boolean splitTerms) {
		this.splitTerms = splitTerms;
	}

	public ArrayList<String> getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(ArrayList<String> blacklist) {
		this.blacklist = blacklist;
	}
	
	public boolean getDoFiltering() {
		return doFiltering;
	}

	public void setDoFiltering(boolean doFiltering) {
		this.doFiltering = doFiltering;
	}

	public int getFilterTermsSize() {
		return filterTermsSize;
	}

	public void setFilterTermsSize(int filterTermsSize) {
		this.filterTermsSize = filterTermsSize;
	}
}
