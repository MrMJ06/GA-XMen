package ti3.xmen.pl;

import ti3.xmen.ProblemaXmen;
import us.lsi.pl.AlgoritmoPLI;

public class TestXmenPLI {

	public static void main(String[] args) {
		ProblemaXmen.create("Mutantes.txt");
		System.out.println("------");
		System.out.println("X-Men: " + ProblemaXmen.listaXmen);
		System.out.println("------");
		System.out.println("Mutantes: " + ProblemaXmen.listaMutantes);
		System.out.println("------");

		String r = XmenPLI.getConstraints("Mutantes.txt");
		AlgoritmoPLI a = AlgoritmoPLI.create();
		a.setConstraints(r);
		a.ejecuta();
		System.out.println("Especificación LPSolve:");
		System.out.println(r);
		System.out.println("------\n");
		System.out.println("Objetivo Solución = " + a.getObjetivo());

		for (int i = 0; i < a.getSolucion().length; i++) {
			if (a.getSolucion(i) > 0) {

				String xIndex = a.getName(i);
				Character xmenStringIndex = new Character(xIndex.charAt(1));
				Integer xmenIndex = new Integer(xmenStringIndex.toString());
				String mIndex = a.getName(i);
				Character mutantStringIndex = new Character(mIndex.charAt(2));
				Integer mutantIndex = new Integer(mutantStringIndex.toString());
				System.out.println("Emparejamientos: Xmen: " + ProblemaXmen.listaXmen.get(xmenIndex).getNombre()
						+ " VS Mutante: " + ProblemaXmen.listaMutantes.get(mutantIndex).getNombre());
			}
		}
	}

}
