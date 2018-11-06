package org.clusterer.app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CasoManual {
	
	
	private List<RefactorizacionManual> casosManuales = new ArrayList<RefactorizacionManual>();
	
	public List<RefactorizacionManual> getCasosManuales() {
		return casosManuales;
	}

	public void setCasosManuales(List<RefactorizacionManual> casosManuales) {
		this.casosManuales = casosManuales;
	}
	
	public List<RefactorizacionManual> getCasoManualJSON(String ruta) {
		List<RefactorizacionManual> rf = new ArrayList<RefactorizacionManual>();
		
		
		JSONParser parser = new JSONParser();
		try {

            Object obj = parser.parse(new FileReader(ruta));

            JSONObject jsonObject = (JSONObject) obj;
            RefactorizacionManual rm = new RefactorizacionManual();
            // loop array
            List<Clase> listaClases = new ArrayList<Clase>();
            JSONArray clusters = (JSONArray) jsonObject.get("Cluster");
            Iterator<List<String>> iterator = clusters.iterator();
            int num = 0;
            while (iterator.hasNext()) {
                //hacer
            		Clase c = new Clase();
            		c.setClase(num);
            		c.setOperaciones(iterator.next());
            		num++;
            		listaClases.add(c);	
            	}
            rm.setClases(listaClases);
            rf.add(rm);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return rf;
    }
}
