import java.util.ArrayList;

public class MetodoOcurrenciaConRep implements MetodoOcurrencia {

	@Override
	public double obtenerOcurrencias(String operacion, ArrayList<String> listaOperaciones) {
		double total = 0;
		for(int i=0; i<listaOperaciones.size(); i++) {
			if(listaOperaciones.get(i).equals(operacion))
				total = total + 1;
		}
		return total;
	}

}
