package org.clusterer.strategy;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

import org.clusterer.distance.JaccardDistance;
import org.clusterer.util.DataTypeNode;
import org.clusterer.util.OperationNode;
import org.ow2.easywsdl.wsdl.api.Operation;

import weka.clusterers.AbstractClusterer;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.DistanceFunction;
import weka.core.Instance;
import weka.core.Instances;


public abstract class ClusteringDistanceStrategy extends ClusteringStrategy
{
	protected Double cutOffValue = 3.0;
	protected Instances dataset;
	protected Hashtable<Integer, ArrayList<Instance>> hashClustering = new Hashtable<Integer, ArrayList<Instance>>();
	
	//Agregado Luciano - Brian
	protected ArrayList<String> blacklist = new ArrayList<String>();
	protected Hashtable<String,Instance> hashOperationInstance = new Hashtable<String,Instance>();
	protected Hashtable<Integer, List<String>> hashClusterOperations = new Hashtable<Integer, List<String>>();
	
	public ClusteringDistanceStrategy() {
		super();
		loadBlacklist();
	}

	
	private void loadBlacklist() {
		blacklist.add("tipo");
		blacklist.add("codigo");
		blacklist.add("numero");
		blacklist.add("desde");
		blacklist.add("hasta");
		blacklist.add("nro");
		blacklist.add("ing");
		blacklist.add("sin");
		blacklist.add("con");
		blacklist.add("dar");
		blacklist.add("para");
		blacklist.add("otros");
		blacklist.add("propio");
		blacklist.add("entre");
		blacklist.add("comp");
		blacklist.add("segun");
	}
	
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
		final ArrayList<String> operationNames = new ArrayList<String>();
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
		int cantOp = getOperations().size();
		String nombreOp = "";
		for (final Operation op : getOperations())
		{
			nombreOp = op.getQName().getLocalPart().toString();
			operationNames.add(op.getQName().getLocalPart().toString());
			final double[] newInst = new double[dataset.numAttributes()];
			ArrayList<String> terms = new ArrayList<String>();
			if(doSplitTerms) {
				terms = flattenAndSplitOperationTerms(op);
			}
			else {
				terms = flattenOperationTerms(op);
			}
			
			
			//terms = flattenOperationTermsAddType(op);
			//terms = flattenAndSplitOperationTermsAddType(op);
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
			
			final Hashtable<Integer, List<String>> clusterInstances = new Hashtable<Integer, List<String>>();
			final Hashtable<String, Integer> OpCluster = new Hashtable<String, Integer>();
			for (int i = 0; i < dataset.numInstances(); i++)
			{
				OpCluster.put(operationNames.get(i), clusterer.clusterInstance(dataset.instance(i)));
				hashOperationInstance.put(operationNames.get(i), dataset.instance(i));
				if (clusterInstances.get(clusterer.clusterInstance(dataset.instance(i))) == null)
				{
					final List<String> newCluster = new ArrayList<String>();
					newCluster.add(operationNames.get(i));
					clusterInstances.put(clusterer.clusterInstance(dataset.instance(i)), newCluster);
				}
				else
				{
					clusterInstances.get(clusterer.clusterInstance(dataset.instance(i))).add(operationNames.get(i));
				}

				final int instance = clusterer.clusterInstance(dataset.instance(i));
				if (hashClustering.get(instance) == null)
				{ // gets the value
				  // for an id)
					hashClustering.put(instance, new ArrayList<Instance>());
				}
				hashClustering.get(instance).add(dataset.instance(i));
				hashClustering.put(instance, hashClustering.get(instance));
			}
			
			hashClusterOperations = clusterInstances;

			final Hashtable<String, DataTypeNode> similarNodes = new Hashtable<String, DataTypeNode>();
			final List<Integer> clusAux1 = new ArrayList<Integer>();
			final List<Integer> clusAux2 = new ArrayList<Integer>();
			for (final Operation op : getOperations())
			{
				final OperationNode operation = new OperationNode(op);
				DataTypeNode input = new DataTypeNode(op.getInput().getElement());
				input.addRelatedOperation(op);
				input.setParameterType(DataTypeNode.INPUT);

				final Integer currentClust = OpCluster.get(op.getQName().getLocalPart());
				if (!clusAux1.contains(currentClust))
				{
					dataTypeNodes.add(input);
					similarNodes.put(op.getQName().getLocalPart() + "-I", input);
					clusAux1.add(currentClust);
				}
				else
				{
					final List<String> opByCluster = clusterInstances.get(currentClust);
					stop: for (final String currentOp : opByCluster)
					{
						if (!currentOp.equals(op.getQName().getLocalPart()))
						{
							for (final Operation op2 : getOperations())
							{
								if (op2.getQName().getLocalPart().equals(currentOp))
								{
									input = similarNodes.get(currentOp + "-I");
									if (input != null)
									{
										input.addRelatedOperation(op);
										break stop;
									}
								}
							}
						}
					}
				}

				DataTypeNode output = new DataTypeNode(op.getOutput().getElement());
				output.addRelatedOperation(op);
				output.setParameterType(DataTypeNode.OUTPUT);
				if (!clusAux2.contains(currentClust))
				{
					dataTypeNodes.add(output);
					similarNodes.put(op.getQName().getLocalPart() + "-O", output);
					clusAux2.add(currentClust);
				}
				else
				{
					final List<String> opByCluster = clusterInstances.get(currentClust);
					stop: for (final String currentOp : opByCluster)
					{
						if (!currentOp.equals(op.getQName().getLocalPart()))
						{
							for (final Operation op2 : getOperations())
							{
								if (op2.getQName().getLocalPart().equals(currentOp))
								{
									output = similarNodes.get(currentOp + "-O");
									if (output != null)
									{
										output.addRelatedOperation(op);
										break stop;
									}
								}

							}
						}
					}
				}

				operation.setInput(input);
				operation.setOutput(output);
				operationNodes.add(operation);

			}
			clusAux1.size();
		}
		catch (final Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		unmergedNodes.addAll(dataTypeNodes);
		mergeOperations();
		//printDistances();
		int i = 1;
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
		
		for (final Operation op : getOperations())
		{
			ArrayList<String> opTerms = new ArrayList<String>();
			if(doSplitTerms) {
				opTerms = flattenAndSplitOperationTerms(op);
			}
			else {
				opTerms = flattenOperationTerms(op);
			}
			
			//uniqueTerms.addAll(flattenOperationTerms(op));
			//ArrayList<String> opTerms = flattenOperationTerms(op);
			
			//Con tipo añadido al final.
			//ArrayList<String> opTerms = flattenOperationTermsAddType(op);
			
			//Con split y add.
			//ArrayList<String> opTerms = flattenAndSplitOperationTermsAddType(op);
			
			//Con split.
			
			
			uniqueTerms.addAll(opTerms);
			repeatedTerms.addAll(opTerms);
		}
		return repeatedTerms;
	}

	//Agregado Luciano - Brian.
	private ArrayList<String> flattenAndSplitOperationTerms(Operation op) {
		final ArrayList<String> terms = new ArrayList<String>();
		final DataTypeNode d1 = new DataTypeNode(op.getInput().getElement());
		final Hashtable<String, String> childrensInput = d1.internFlattenDataTypes(op.getInput().getElement());
		final Hashtable<String, String> childrensOutput = d1.internFlattenDataTypes(op.getOutput().getElement());
		
		//Operation name.
		ArrayList<String> splitedName = splitTerms(op.getQName().getLocalPart().toString());
		if(doFiltering)
			for(String t: splitedName) {
				if(!filterTerm(t)) {
					terms.add(t);
				}
			}
		else
			terms.addAll(splitedName);
		
		//Operation input.
		for (final String children : childrensInput.keySet())
		{
			ArrayList<String> splitedChildren = splitTerms(children);
			if(doFiltering)
				for(String t: splitedChildren) {
					if(!filterTerm(t)) {
						terms.add(t);
					}
				}
			else
				terms.addAll(splitedChildren);
			//terms.add(String.valueOf(childrensInput.get(children)));
		}
		
		//Operation output.
		for (final String children : childrensOutput.keySet())
		{
			ArrayList<String> splitedChildren = splitTerms(children);
			if(doFiltering)
				for(String t: splitedChildren) {
					if(!filterTerm(t)) {
						terms.add(t);
					}
				}
			else
				terms.addAll(splitedChildren);
			//terms.add(String.valueOf(childrensOutput.get(children)));
		}
		return terms;
	}
	//Fin agregado.
	
	private ArrayList<String> flattenAndSplitOperationTermsAddType(Operation op) {
		final ArrayList<String> terms = new ArrayList<String>();
		final DataTypeNode d1 = new DataTypeNode(op.getInput().getElement());
		final Hashtable<String, String> childrensInput = d1.internFlattenDataTypes(op.getInput().getElement());
		final Hashtable<String, String> childrensOutput = d1.internFlattenDataTypes(op.getOutput().getElement());
		
		terms.addAll(splitTerms(op.getQName().getLocalPart().toString()));
		
		for (final String children : childrensInput.keySet())
		{
			ArrayList<String> splitedChildrensInput = splitTerms(children);
			terms.add(children+"_"+String.valueOf(childrensInput.get(children)));
		}
		for (final String children : childrensOutput.keySet())
		{
			ArrayList<String> splitedChildrensOutput = splitTerms(children);
			terms.add(children+"_"+String.valueOf(childrensOutput.get(children)));
		}
		return terms;
	}

	private ArrayList<String> flattenOperationTerms(final Operation op)
	{
		final ArrayList<String> terms = new ArrayList<String>();
		final DataTypeNode d1 = new DataTypeNode(op.getInput().getElement());
		final Hashtable<String, String> childrensInput = d1.internFlattenDataTypes(op.getInput().getElement());
		final Hashtable<String, String> childrensOutput = d1.internFlattenDataTypes(op.getOutput().getElement());
		
		terms.add(op.getQName().getLocalPart().toString());
		
		for (final String children : childrensInput.keySet())
		{	
			terms.add(children);
			//terms.add(String.valueOf(childrensInput.get(children)));
		}
		for (final String children : childrensOutput.keySet())
		{
			terms.add(children);
			//terms.add(String.valueOf(childrensOutput.get(children)));
		}
		return terms;
	}
	
	private ArrayList<String> flattenOperationTermsAddType(final Operation op)
	{
		final ArrayList<String> terms = new ArrayList<String>();
		final DataTypeNode d1 = new DataTypeNode(op.getInput().getElement());
		final Hashtable<String, String> childrensInput = d1.internFlattenDataTypes(op.getInput().getElement());
		final Hashtable<String, String> childrensOutput = d1.internFlattenDataTypes(op.getOutput().getElement());
		
		terms.add(op.getQName().getLocalPart().toString());
		
		for (final String children : childrensInput.keySet())
		{	
			terms.add(children +"_"+ childrensInput.get(children));
		}
		for (final String children : childrensOutput.keySet())
		{
			terms.add(children +"_"+ childrensOutput.get(children));
		}
		return terms;
	}

	private ArrayList<String> splitTerms(String children) {
		String[] childrenList = children.split("_");
		ArrayList<String> ch =  new ArrayList<String>(Arrays.asList(childrenList));
		ArrayList<String> childrenSplited = new ArrayList<String>();
		for(String s: ch) {
			childrenSplited.addAll(Arrays.asList(s.split("(?=[A-Z])")));
		}
		
		
		ArrayList<String> lowerCaseChildrenSplited = new ArrayList<String>();
		for(String s: childrenSplited) {
			lowerCaseChildrenSplited.add(s.toLowerCase());
		}
		
		return lowerCaseChildrenSplited;
	}
	
	//Agregado Luciano - Brian.
	public void printDistances() {
		DistanceFunction jaccard = new JaccardDistance();
		for(Integer i: hashClusterOperations.keySet()) {
			System.out.println("");
			System.out.println("Distancias");
			for(String op1: hashClusterOperations.get(i)) {
				for(String op2: hashClusterOperations.get(i)) {
					if(!op1.equals(op2)) {
						System.out.println(op1 + " ----- " + op2 +": " +  jaccard.distance(hashOperationInstance.get(op1), hashOperationInstance.get(op2)));
					}
				}
			}
		}
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

}
