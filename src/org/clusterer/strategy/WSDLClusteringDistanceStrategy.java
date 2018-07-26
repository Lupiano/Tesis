package org.clusterer.strategy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

import org.clusterer.util.DataTypeNode;
import org.clusterer.util.OperationNode;
import org.ow2.easywsdl.wsdl.WSDLFactory;
import org.ow2.easywsdl.wsdl.api.Description;
import org.ow2.easywsdl.wsdl.api.InterfaceType;
import org.ow2.easywsdl.wsdl.api.Operation;
import org.ow2.easywsdl.wsdl.api.WSDLException;
import org.ow2.easywsdl.wsdl.api.WSDLReader;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.InputSource;

import net.sf.json.JSONObject;
import weka.clusterers.AbstractClusterer;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.DistanceFunction;
import weka.core.Instance;
import weka.core.Instances;

public class WSDLClusteringDistanceStrategy extends ClusteringStrategy
{
	protected Double cutOffValue = 3.0;
	protected Instances dataset;
	protected Hashtable<Integer, ArrayList<Instance>> hashClustering = new Hashtable<Integer, ArrayList<Instance>>();
	protected List<MultipartFile> listWsdls;
	private ArrayList<List<MultipartFile>> wsdlClusters;

	@Override
	public void generateCluster()
	{
		ArrayList<String> generateTermsVector = generateTermsVector();
		final ArrayList<String> repeatedTerms = new ArrayList<String>(generateTermsVector);
		final ArrayList<String> allTerms = new ArrayList<String>(new HashSet<String>(generateTermsVector));
		final int[] allTermsFrequency = generateAllTermsFrequency(allTerms, repeatedTerms);
		final ArrayList<Attribute> atts = new ArrayList<Attribute>();
		int index = 1;
		for (int i = 1; i <= allTerms.size(); i++)
		{
			atts.add(new Attribute("Qtype" + index));
			index++;
		}
		final ArrayList<String> wsdlNames = new ArrayList<String>();
		// Instances dataset = null;
		dataset = new Instances("distanceClustering", atts, 0);
		PrintWriter out = null;
		String datasetBottom = "";
		try
		{
			out = new PrintWriter("/tmp/botomup2.txt");
		}
		catch (final FileNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int cantWsdls = getWsdls().size();
		String nombreWsdl = "";
		for (final MultipartFile wsdl : getWsdls())
		{
			nombreWsdl = wsdl.getName();
			wsdlNames.add(nombreWsdl);
			final double[] newInst = new double[dataset.numAttributes()];
			ArrayList<String> terms = new ArrayList<String>();
			
			if(doSplitTerms) {
				terms = flattenAndSplitOperationTerms(wsdl);
			}
			else {
				terms = flattenOperationTerms(wsdl);
			}
			
			
			for (int i = 0; i < allTerms.size(); i++)
			{
				final Integer freq = Collections.frequency(terms, allTerms.get(i));
				double inverseFreq = (double)freq/allTermsFrequency[i];
				//newInst[i] = inverseFreq;
				newInst[i] = freq;
			}
			datasetBottom = new DenseInstance(1.0, newInst).toString() + "\n";
			out.print(datasetBottom);
			dataset.add(new DenseInstance(1.0, newInst));
		}
		out.print(dataset.numInstances());
		out.close();
		//out.println(datasetBottom);
		try
		{
			final AbstractClusterer clusterer = getClusterer();

			clusterer.buildClusterer(dataset);
			
			final Hashtable<Integer, List<MultipartFile>> clusterInstances = new Hashtable<Integer, List<MultipartFile>>();
			final Hashtable<String, Integer> WsdlCluster = new Hashtable<String, Integer>();
			for (int i = 0; i < dataset.numInstances(); i++)
			{
				try {
					WsdlCluster.put(wsdlNames.get(i), clusterer.clusterInstance(dataset.instance(i)));
					if (clusterInstances.get(clusterer.clusterInstance(dataset.instance(i))) == null)
					{
						final List<MultipartFile> newCluster = new ArrayList<MultipartFile>();
						newCluster.add(getWsdls().get(i));
						clusterInstances.put(clusterer.clusterInstance(dataset.instance(i)), newCluster);
					}
					else
					{
						clusterInstances.get(clusterer.clusterInstance(dataset.instance(i))).add(getWsdls().get(i));
					}
				}
				catch (Exception e){
					System.out.println("Operacion no clusterizada.");
				}
				
			}
			
			this.wsdlClusters = Collections.list(clusterInstances.elements());
			
		}
		catch (final Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int[] generateAllTermsFrequency(ArrayList<String> allTerms, ArrayList<String> repeatedTerms) {
		int[] freq = new int[allTerms.size()];
		for(int i=0; i<allTerms.size(); i++) {
			freq[i] = Collections.frequency(repeatedTerms, allTerms.get(i));
		}
		return freq;
	}

	private ArrayList<String> generateTermsVector()
	{
		final HashSet<String> uniqueTerms = new HashSet<String>();
		final ArrayList<String> repeatedTerms = new ArrayList<String>();
		
		for (final MultipartFile wsdl : getWsdls())
		{	
			ArrayList<String> opTerms = new ArrayList<String>();
			
			if(doSplitTerms) {
				opTerms = flattenAndSplitOperationTerms(wsdl);
			}
			else {
				opTerms = flattenOperationTerms(wsdl);
			}
			uniqueTerms.addAll(opTerms);
			repeatedTerms.addAll(opTerms);
		}
		return repeatedTerms;
	}

	private ArrayList<String> flattenOperationTerms(final MultipartFile wsdl) {
		
		final ArrayList<String> terms = new ArrayList<String>();
		
		final Description description = getDescriptionFromWSDLFile(wsdl);
		final InterfaceType portType = description.getInterfaces().get(0);
		
		for (final Operation op : portType.getOperations()) {
			final DataTypeNode d1 = new DataTypeNode(op.getInput().getElement());
			final Hashtable<String, String> childrensInput = d1.internFlattenDataTypes(op.getInput().getElement());
			final Hashtable<String, String> childrensOutput = d1.internFlattenDataTypes(op.getOutput().getElement());
			
			for (final String children : childrensInput.keySet())
			{
				terms.add(children);
			}
			for (final String children : childrensOutput.keySet())
			{
				terms.add(children);
			}
			
			terms.add(op.getQName().getLocalPart().toString());
		}
		
		terms.add(parseWSDLName(wsdl.getName()));
		
		return terms;
	}

	private ArrayList<String> flattenAndSplitOperationTerms(final MultipartFile wsdl)
	{
		final ArrayList<String> terms = new ArrayList<String>();
		
		final Description description = getDescriptionFromWSDLFile(wsdl);
		final InterfaceType portType = description.getInterfaces().get(0);
		
		for (final Operation op : portType.getOperations()) {
			final DataTypeNode d1 = new DataTypeNode(op.getInput().getElement());
			final Hashtable<String, String> childrensInput = d1.internFlattenDataTypes(op.getInput().getElement());
			final Hashtable<String, String> childrensOutput = d1.internFlattenDataTypes(op.getOutput().getElement());
			
			for (final String children : childrensInput.keySet())
			{
				ArrayList<String> splitedChildrensInput = splitTerms(children);
				if(doFiltering)
					for(String t: splitedChildrensInput) {
						if(!filterTerm(t)) {
							terms.add(t);
						}
					}
				else
					terms.addAll(splitedChildrensInput);
			}
			for (final String children : childrensOutput.keySet())
			{
				ArrayList<String> splitedChildrensOutput = splitTerms(children);
				if(doFiltering)
					for(String t: splitedChildrensOutput) {
						if(!filterTerm(t)) {
							terms.add(t);
						}
					}
				else
					terms.addAll(splitedChildrensOutput);
			}
			
			ArrayList<String> opName = splitTerms(op.getQName().getLocalPart().toString());
			if(doFiltering)
				for(String t: opName) {
					if(!filterTerm(t)) {
						terms.add(t);
					}
				}
			else
				terms.addAll(splitTerms(op.getQName().getLocalPart().toString()));
		}
		
		ArrayList<String> wsdlName = splitTerms(parseWSDLName(wsdl.getName()));
		if(doFiltering)
			for(String t: wsdlName) {
				if(!filterTerm(t)) {
					terms.add(t);
				}
			}
		else
			terms.addAll(wsdlName);
		return terms;
	}
	
	private ArrayList<String> splitTerms(String children) {
		String[] childrenList = children.split("_");
		ArrayList<String> ch =  new ArrayList<String>(Arrays.asList(childrenList));
		ArrayList<String> childrenSplited = new ArrayList<String>();
		for(String s: ch) {
			childrenSplited.addAll(Arrays.asList(s.split("(?=[A-Z])")));
		}
			
		return childrenSplited;
	}

	protected double getEsquaredErrors(final int numClusters, final DistanceFunction euclidean, final Instances centroids)
	{
		double sum = 0;
		double error = 0;
		for (int i = 0; i < numClusters; i++)
		{

			final ArrayList<Instance> clusterInstances = hashClustering.get(i);
			sum = 0;
			for (int z = 0; z < clusterInstances.size(); z++)
			{
				final Double dist = euclidean.distance(clusterInstances.get(z), centroids.get(i));
				sum += dist * dist;
			}
			error += sum;
		}

		return error;
	}

	@Override
	public JSONObject validateCluster() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<MultipartFile> getWsdls(){
		return listWsdls;
	}
	
	public void setWsdls(List<MultipartFile> listWsdls) {
		this.listWsdls = listWsdls;
	}
	
	private Description getDescriptionFromWSDLFile(final MultipartFile wsdlFile)
	{
		WSDLReader reader = null;
		try
		{
			reader = WSDLFactory.newInstance().newWSDLReader();
		}
		catch (final WSDLException e)
		{
			e.printStackTrace();
		}
		try
		{
			final Description description = reader.read(new InputSource(wsdlFile.getInputStream()));
			return description;
		}
		catch (WSDLException | URISyntaxException | IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<List<MultipartFile>> getWsdlClusters() {
		return wsdlClusters;
	}

	public void setWsdlClusters(ArrayList<List<MultipartFile>> clusters) {
		this.wsdlClusters = clusters;
	}
	private String parseWSDLName(String name) {
		//Eliminar .wsdl
		return name.substring(0, name.length() - 5);
	}


}
