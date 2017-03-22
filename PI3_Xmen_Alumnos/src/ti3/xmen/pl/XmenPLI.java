package ti3.xmen.pl;

import java.util.ArrayList;
import java.util.List;

import ti3.xmen.Mutante;
import ti3.xmen.ProblemaXmen;

public class XmenPLI {

	public static String getConstraints(String s) {
		ProblemaXmen.create(s);
		List<Mutante> xm = ProblemaXmen.listaXmen;
		List<Mutante> mt = ProblemaXmen.listaMutantes;
		Integer numXmen = ProblemaXmen.listaXmen.size();
		Integer numMutantes = ProblemaXmen.listaMutantes.size();
		String r = "max: ";

		for (int i = 0; i < numXmen; i++) {
			for (int j = 0; j < numMutantes; j++) {
				
				if (xm.get(i).getSumaCaracteristicas() > mt.get(j).getSumaCaracteristicas()) {
					if (i != 0 || j != 0) {
						r += "+";
					}
					r += "x" + i + "" + j ;
				}
			}
		}
		

		r+=";\n";
		for(int i = 0;i<numXmen;i++){
		for (int j = 0; j < numMutantes; j++) {
			r += "x" + i + "" + j;
			if (j != numMutantes - 1) {
				r += "+";
			}
		}
		r += "<=" + xm.get(i).getNumBatallas() + ";\n";
	}

	for(int j = 0;j<numMutantes;j++){
		for (int i = 0; i < numXmen; i++) {
			r += "x" + i + "" + j;
			if (i != numMutantes - 1) {
				r += "+";
			}
		}
		r += "=" + mt.get(j).getNumBatallas() + ";\n";
	}
	for(int i = 0;i<numXmen;i++){
		for (int j = 0; j < numMutantes; j++) {
			if (!(xm.get(i).isLider()) && mt.get(j).isLider()){
				if (i != 0 || j != 0) {
					r += "+";
				}
				r += "x" + i + "" + j ;
			}
			if(xm.get(i).isLider() && !(mt.get(j).isLider())) {
				if (i != 0 || j != 0) {
					r += "+";
				}
				r += "x" + i + "" + j ;
			}
		}
	}

	for(int j = 0;j<numMutantes;j++)
	{
	for (int i = 0; i < numXmen; i++) {
			if (getTipo(xm.get(i)).contains(TipoMutante.FUEGO) && getTipo(mt.get(j)).contains(TipoMutante.HIELO)
					|| getTipo(mt.get(j)).contains(TipoMutante.FUEGO) && getTipo(xm.get(i)).contains(TipoMutante.HIELO)
					|| getTipo(mt.get(j)).contains(TipoMutante.FUERZA)
							&& getTipo(xm.get(i)).contains(TipoMutante.MATERIA)
					|| getTipo(xm.get(i)).contains(TipoMutante.FUERZA)
							&& getTipo(mt.get(j)).contains(TipoMutante.MATERIA)) {
				r += "x" + i + "" + j + " = 0;\n";
			}
		}
	}
	for (int i = 0; i < numXmen; i++) {
		for (int j = 0; j < numMutantes; j++) {
			if (xm.get(i).getSumaCaracteristicas() < mt.get(j).getSumaCaracteristicas()) {
				r += "x" + i + "" + j + " = 0;\n";
			}
		}
	}
	r+="bin ";for(
	int i = 0;i<numMutantes;i++)
	{
		for (int j = 0; j < numXmen; j++) {
			if (i != 0 || j != 0) {
				r += ",";
			}
			r += "x" + i + "" + j;

		}
	}r+=";";return r;
	}

	private static List<TipoMutante> getTipo(Mutante m) {
		Integer max = 4;
		List<TipoMutante> listaTipos = new ArrayList<TipoMutante>();
		if (m.getFuego() > max) {

			listaTipos.add(TipoMutante.FUEGO);
		}
		if (m.getHielo() > max) {

			listaTipos.add(TipoMutante.HIELO);
		}
		if (m.getFuerza() > max) {

			listaTipos.add(TipoMutante.FUERZA);
		}
		if (m.getMateria() > max) {

			listaTipos.add(TipoMutante.MATERIA);
		}
		return listaTipos;
	}
}