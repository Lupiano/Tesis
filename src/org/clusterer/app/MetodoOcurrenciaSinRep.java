package org.clusterer.app;
import java.util.ArrayList;

public class MetodoOcurrenciaSinRep implements MetodoOcurrencia{

	@Override
	public double obtenerOcurrencias(String operacion, ArrayList<String> listaOperaciones) {
		for(String e: listaOperaciones) {
			if(e.equals(operacion))
				return 1.0;
		}
		return 0.0;
		
	}

}
