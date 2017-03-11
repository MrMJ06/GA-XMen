package ti3.xmen;

import java.util.*;
import us.lsi.stream.Stream2;

public class ProblemaXmen {

	public static List<Mutante> listaMutantes;
	public static List<Mutante> listaXmen;
	
	public ProblemaXmen(String file) {
		super();
		leeXmen(file);
	}
	
	public static void leeXmen(String file){	
		List<String> ls = Stream2.fromFile(file).toList();
		listaMutantes = new ArrayList<Mutante>();
		listaXmen = new ArrayList<Mutante>();
		int index = 0;
		for(String s : ls){
			String[] at = Stream2.fromString(s, ",").toArray((int x)->new String[x]);
			Mutante mutante = Mutante.create(index, at);
			if (mutante.isXmen())
				listaXmen.add(mutante);
			else
				listaMutantes.add(mutante);
			index++;
		}
	}

	public static ProblemaXmen create(String file) {		
		return new ProblemaXmen(file);
	}

}
