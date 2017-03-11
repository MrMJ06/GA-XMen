package ti3.xmen.ag;

import java.util.ArrayList;
import java.util.List;
import ti3.xmen.Mutante;
import ti3.xmen.pl.TipoMutante;
import us.lsi.ag.ProblemaAGIndex;
import us.lsi.ag.agchromosomes.IndexChromosome;
import us.lsi.stream.Stream2;



public class ProblemaXmenAG implements ProblemaAGIndex<List<Integer>>{
	private static List<Mutante> listaMutantes;
	private static List<Mutante> listaXmen;
	
	public static ProblemaXmenAG create(String fichero){
		return new ProblemaXmenAG(fichero);
	}
	
	public ProblemaXmenAG(String fichero){
		List<String> ls = Stream2.fromFile(fichero).toList();
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
	
	public List<Integer> getSolucion(IndexChromosome cr) {
		
		return cr.decode();
	}
	
	public Double fitnessFunction(IndexChromosome ls) {
		
		List<Integer> lc = getSolucion(ls);
		Double VX=0.;//Maximizar
		Double P=0.;//Penalizacionnes
		
		for(int i=0;i<lc.size();i++){
			
			Mutante mutante = listaMutantes.get(i);
			Mutante Xmen = listaXmen.get(lc.get(i));
			Integer caractMutante = mutante.getSumaCaracteristicas();
			Integer caractXmen = Xmen.getSumaCaracteristicas();
			
			if(caractMutante<=caractXmen){
				VX++;
			}else if(caractMutante>caractXmen){
				P++;
			}
			if(Xmen.getNumBatallas()<getNumBatallasXmen(lc, Xmen)){
				P++;
			}
			if(Xmen.isLider() == false && mutante.isLider()
					|| Xmen.isLider() && mutante.isLider() == false){
				P++;
			}
			if(getTipo(Xmen).contains(TipoMutante.FUEGO) 
					&& getTipo(mutante).contains(TipoMutante.HIELO)
			|| getTipo(mutante).contains(TipoMutante.FUEGO)
					&& getTipo(Xmen).contains(TipoMutante.HIELO)
			|| getTipo(mutante).contains(TipoMutante.FUERZA)
					&& getTipo(Xmen).contains(TipoMutante.MATERIA)
			|| getTipo(Xmen).contains(TipoMutante.FUERZA)
					&& getTipo(mutante).contains(TipoMutante.MATERIA)){
				P++;
			}
		}
		
		return VX-P*Math.pow(getObjectsNumber(), 2);
	}
	
	private static Integer getNumBatallasXmen(List<Integer> l , Mutante Xmen){
		Integer res = (int) l.stream().filter(i->listaXmen.get(l.get(i)).equals(Xmen)).count();
		return res;
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
	
	public Integer getObjectsNumber() {
		
		return listaMutantes.size();
	}
	
	

	
	
}
