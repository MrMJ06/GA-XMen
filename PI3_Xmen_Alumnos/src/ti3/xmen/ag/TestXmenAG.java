package ti3.xmen.ag;

import ti3.xmen.ProblemaXmen;
import us.lsi.ag.*;
import us.lsi.ag.agchromosomes.ChromosomeFactory;
import us.lsi.ag.agchromosomes.IndexChromosome;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;

public class TestXmenAG {

	public static void main(String[] args){
		
		AlgoritmoAG.ELITISM_RATE  = 0.30;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 200;
		StoppingConditionFactory.NUM_GENERATIONS = 700;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 10;
		StoppingConditionFactory.FITNESS_MIN = 100.0;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionType.GenerationCount;

		ProblemaXmen.create("Mutantes.txt");
		System.out.println("------");
		System.out.println("Listado X-Men: " + ProblemaXmen.listaXmen);
		System.out.println("------");
		System.out.println("Listado Mutantes: " + ProblemaXmen.listaMutantes);
		System.out.println("------");
		System.out.println("Solución:");
		
		ProblemaXmenAG p = ProblemaXmenAG.create("Mutantes.txt");
		AlgoritmoAG a = new AlgoritmoAG(ChromosomeType.IndexRange, p);
		a.ejecuta();
		IndexChromosome cr = ChromosomeFactory.asIndex(a.getBestFinal());
		
		System.out.println("Emparejamientos:  Mutante VS Xmen\n");
		
		for(int i=0;i<p.getSolucion(cr).size();i++){
			System.out.println(ProblemaXmen.listaMutantes.get(i)+" VS "+ProblemaXmen.listaXmen.get(p.getSolucion(cr).get(i)) );
		}
		System.out.println("\nFitness de la mejor solución: "+p.fitnessFunction(cr));
		System.out.println("------");
	}	

}
