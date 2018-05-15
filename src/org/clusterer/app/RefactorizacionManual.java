package org.clusterer.app;
import java.util.ArrayList;
import java.util.List;

public class RefactorizacionManual {
	
	private String nombre="";
	private List<Clase> clases;
	
	public RefactorizacionManual(){
		clases= new ArrayList<Clase>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	
	public void add(int pos, Clase c) {
		clases.add(pos, c);
	}
}