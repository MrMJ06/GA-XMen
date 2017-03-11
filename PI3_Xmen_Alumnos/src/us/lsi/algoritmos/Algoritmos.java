package us.lsi.algoritmos;

import us.lsi.ag.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.ProblemaAG;
import us.lsi.pl.AlgoritmoPL;
import us.lsi.pl.AlgoritmoPLI;
import us.lsi.pl.ProblemaPL;

public class Algoritmos {
	
	/**
	 *
	 * @param tipo El tipo del cromomosoma
	 * @param p Problema
	 * @return AlgoritmoAG
	 */
	
	public static AlgoritmoAG createAG(ChromosomeType tipo, ProblemaAG p) {
		return new AlgoritmoAG(tipo,p);
	}
		
	/**
	 * Los tipos involucrados pueden encontrarse en el paquete <a href="https://commons.apache.org/proper/commons-math/apidocs/org/apache/commons/math3/optim/linear/package-summary.html" target="_blank">Apache</a>
	 * 
	 * @param p  Problema de Programación Lineal
	 * @return Un algoritmo para resolver le conjunto de restricciones lineales con variables reales. 
	 * Ignora las declaraciones de varibles no reales y otros tipos de restrcciones distintas de  las lineales
	 */
	public static AlgoritmoPL createPL(ProblemaPL p) {
		return AlgoritmoPL.create(p);
	}
	
	/**
	 * Los tipos involucrados pueden encontrarse en el paquete <a href="https://commons.apache.org/proper/commons-math/apidocs/org/apache/commons/math3/optim/linear/package-summary.html" target="_blank">Apache</a>
	 * 
	 * @param p  Problema de Programación Lineal
	 * @param fichero  Un fichero para guardar las restricciones del problema
	 * @return Un algoritmo para resolver le conjunto de restricciones lineales
	 * Ignora las declaraciones de varibles no reales y otros tipos de restrcciones distintas de  las lineales
	 */
	public static AlgoritmoPL createPL(ProblemaPL p, String fichero) {
		return AlgoritmoPL.create(p,fichero);
	}
	
	
	/**
	 * Los tipos involucrados pueden encontrarse en el paquete <a href="http://lpsolve.sourceforge.net/5.5/" target="_blank">LpSolve</a>
	 * 
	 * @param fichero  Describe un problema de Programación Lineal
	 * @return Un algoritmo para resolver le conjunto de restricciones lineales, variables de tipo real, entero y binarias, 
	 * variables libres y semicontinuas y otros tipos de restricciones como las 
	 * <a href="http://en.wikipedia.org/wiki/Special_ordered_set" target="_blank">Sos</a>
	 * 
	 */
	public static AlgoritmoPLI createPLI(String fichero) {
		return AlgoritmoPLI.create(fichero);
	}
	
	/**
	 * Los tipos involucrados pueden encontrarse en el paquete <a href="http://lpsolve.sourceforge.net/5.5/" target="_blank">LpSolve</a>
	 * 
	 * @param p  Problema de Programación Lineal
	 * @param fichero  Fichero para guardar las restrcciones del problema
	 * @return Un algoritmo para resolver le conjunto de restricciones lineales con variables de tipo real, entero y binarias, 
	 * variables libres y semicontinuas y otros tipos de restricciones como las 
	 * <a href="http://en.wikipedia.org/wiki/Special_ordered_set" target="_blank">Sos</a>
	 * 
	 */
	public static AlgoritmoPLI createPLI(ProblemaPL p, String fichero) {
		return AlgoritmoPLI.create(p,fichero);
	}
	
}
