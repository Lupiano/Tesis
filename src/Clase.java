import java.util.ArrayList;
import java.util.List;

public class Clase {
	
	private int clase;
	private List<String> operaciones;
	
	public Clase() {
		operaciones = new ArrayList<String>();
	}

	public int getClase() {
		return clase;
	}

	public void setClase(int clase) {
		this.clase = clase;
	}

	public List<String> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(List<String> operaciones) {
		this.operaciones = operaciones;
	}
}