package org.clusterer.strategy;

import org.clusterer.distance.JaccardDistance;

import weka.clusterers.EM;
import weka.clusterers.HierarchicalClusterer;
import weka.clusterers.SimpleKMeans;
import weka.clusterers.XMeans;
//import org.clusterer.app.XMeans;
import weka.core.DistanceFunction;
import weka.clusterers.Cobweb;
import weka.clusterers.DBSCAN;


public class StrategyConstructor
{


	public static ClusteringStrategy getStrategy(final String strategyName, final Integer numberCluster) throws Exception
	{
		ClusteringStrategy strategy;
		switch (strategyName)
		{
			case "hierarchy":
				return new ClusteringHierarchyStrategy();
			case "kmeans":
			{
				final SimpleKMeans kmeans = new SimpleKMeans();
				kmeans.setNumClusters(numberCluster);
				
				strategy = new KmeansStrategy();
				strategy.setClusterer(kmeans);
				return strategy;
			}
			case "xmeans":
			{
				final XMeans xmeans = new XMeans();
				xmeans.setMinNumClusters(1);
				xmeans.setMaxNumClusters(150);
				xmeans.setMaxIterations(10000);
				
				DistanceFunction jaccard = new JaccardDistance();
				xmeans.setDistanceF(jaccard);
				
				strategy = new XmeansStrategy();
				strategy.setClusterer(xmeans);
				
				return strategy;
			}
			case "em":
			{
				final EM em = new EM();
				em.setNumClusters(numberCluster);
				strategy = new EMStrategy();
				strategy.setClusterer(em);
				return strategy;
			}
			case "cobweb":
			{
				final Cobweb cobweb = new Cobweb();
				strategy = new XmeansStrategy();
				strategy.setClusterer(cobweb);
				return strategy;
			}
			default:
				return null;
		}
	}
		
		public static ClusteringStrategy getWsdlStrategy(final String strategyName, final Integer numberCluster) throws Exception
		{

			ClusteringStrategy strategy = new WSDLClusteringDistanceStrategy();
			
			switch (strategyName)
			{
				case "hierarchy":
					return new ClusteringHierarchyStrategy();
				case "kmeans":
				{
					final SimpleKMeans kmeans = new SimpleKMeans();
					kmeans.setNumClusters(numberCluster);
					
					strategy.setClusterer(kmeans);
					return strategy;
				}
				case "xmeans":
				{
					final XMeans xmeans = new XMeans();
					xmeans.setMinNumClusters(1);
					xmeans.setMaxNumClusters(150);
					xmeans.setMaxIterations(10000);
					
					DistanceFunction jaccard = new JaccardDistance();
					xmeans.setDistanceF(jaccard);
					
					strategy.setClusterer(xmeans);
					return strategy;
				}
				case "em":
				{
					final EM em = new EM();
					em.setNumClusters(numberCluster);
					
					strategy.setClusterer(em);
					return strategy;
				}
				case "cobweb":
				{
					final Cobweb cobweb = new Cobweb();
					strategy.setClusterer(cobweb);
					return strategy;
				}	
				default:
					return null;
			}
		}
}
