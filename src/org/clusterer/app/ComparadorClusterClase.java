package org.clusterer.app;
import java.util.ArrayList;

public class ComparadorClusterClase {
	
	public MetodoOcurrencia metodoOcurrencia;
	
	public MetodoOcurrencia getMetodoOcurrencia() {
		return metodoOcurrencia;
	}

	public void setMetodoOcurrencia(MetodoOcurrencia metodoOcurrencia) {
		this.metodoOcurrencia = metodoOcurrencia;
	}

	public double obtenerIntersecciones(ArrayList<String> cluster, ArrayList<String> clase) {
		double total = 0.0;
		for(int i=0; i<cluster.size(); i++) {
			total = total + metodoOcurrencia.obtenerOcurrencias(cluster.get(i), clase);
		}
		return total;
	}
}
