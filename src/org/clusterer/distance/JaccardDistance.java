package org.clusterer.distance;

import java.util.ArrayList;
import java.util.Enumeration;

import weka.core.DistanceFunction;
import weka.core.EuclideanDistance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.NormalizableDistance;
import weka.core.Option;
import weka.core.neighboursearch.PerformanceStats;

public class JaccardDistance implements DistanceFunction {
	
	@Override
	public double distance(Instance arg0, Instance arg1) {
		int count = 0;
		int totalInstances = arg0.numAttributes();
		int total = 0;
		for(int i=0; i<totalInstances; i++) {
			if(arg0.value(i) > 0.0 || arg1.value(i) > 0.0) {
				total ++;
			}
			if((arg0.value(i) > 0.0) && arg1.value(i) > 0.0) {
				count ++;
			}
		}
		double result = (double)count/total;
		double jaccard = 100 - result*100;
		return jaccard;
	}

	@Override
	public String[] getOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumeration<Option> listOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOptions(String[] arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double distance(Instance arg0, Instance arg1, PerformanceStats arg2) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double distance(Instance arg0, Instance arg1, double arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double distance(Instance arg0, Instance arg1, double arg2, PerformanceStats arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAttributeIndices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instances getInstances() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getInvertSelection() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void postProcessDistances(double[] arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAttributeIndices(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInstances(Instances arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setInvertSelection(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Instance arg0) {
		// TODO Auto-generated method stub
		
	}

}
