package org.clusterer.ws.handler;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.clusterer.util.Pair;
import org.ow2.easywsdl.wsdl.api.Operation;
import org.ow2.easywsdl.wsdl.impl.wsdl11.OperationImpl;
import org.springframework.web.multipart.MultipartFile;


public class OperarionSimilarityHandler
{
	//private AbstractMap <Operation,Set<Operation>> opSimilSet;
	private final AbstractMap<String, Set<String>> opSimilSet;

	public AbstractMap<String, Set<String>> getOpSimilSet()
	{
		return opSimilSet;
	}


	public OperarionSimilarityHandler()
	{
		opSimilSet = new HashMap<String, Set<String>>();

	}


	//	public AbstractMap<Pair, Double> generateOperationSimilarity(final List<URL> WSDLLocations)
	//	{
	//		return generateOperationSimilarity(WSDLLocations, 10, 0.0d, 0.8d);
	//	}

	public AbstractMap<Pair, Double> generateOperationSimilarity(final List<MultipartFile> listFiles, final int levels,
			final double botLimit, final double topLimit)
	{


		final AbstractMap<Pair, Double> opSimil = new HashMap<Pair, Double>();
		double simil = 0;

		//System.out.println("Simil Total Limit bottom " + botLimit + " top: " + topLimit);

		for (int si = 1; si <= levels && simil < topLimit; si++)
		{
			simil = botLimit + (double) si / levels * (topLimit - botLimit);

			//System.out.println("Simil: " + simil);
			final ClusteringHandler ch = new ClusteringHandler();
			final List<List<Operation>> res = (List<List<Operation>>) ch.clusterWSDLDocuments(listFiles, simil).get(
					"clusterOperations");
			for (final Iterator<List<Operation>> i = res.iterator(); i.hasNext();)
			{
				final List<Operation> group = i.next();
				for (final Iterator<Operation> j = group.iterator(); j.hasNext();)
				{
					final OperationImpl o1 = (OperationImpl) j.next();
					for (final Iterator<Operation> k = group.iterator(); k.hasNext();)
					{

						final OperationImpl o2 = (OperationImpl) k.next();
						if (o1.getModel().getName() != o2.getModel().getName())
						{
							if (simil == topLimit)
							{
								opSimil.remove(new Pair(o1.getModel().getName(), o2.getModel().getName()));
								opSimilSet.get(o1.getModel().getName()).remove(o2.getModel().getName());
							}
							else
							{
								opSimil.put(new Pair(o1.getModel().getName(), o2.getModel().getName()), simil);
								if (opSimilSet.containsKey(o1.getModel().getName()))
								{
									opSimilSet.get(o1.getModel().getName()).add(o2.getModel().getName());
								}
								else
								{
									final Set<String> set = new HashSet<String>();
									set.add(o2.getModel().getName());
									opSimilSet.put(o1.getModel().getName(), set);
								}
							}
						}
						//opSimil.put(o1.getModel().getName()+":"+o2.getModel().getName(), simil);
						//la opcion comentada agrega uri a las claves... por si hay conflicto de nombres
						//opSimil.put(o1.getQName()+":"+o2.getQName(), simil);
					}

				}

			}
		}
		return opSimil;

	}

}
