package ti3.xmen;

import java.util.*;

public class SolucionXmen {

	private Map<Mutante, Mutante> batallas;
	private Map<Mutante, Integer> batallasPorMutante;
	private Integer batallasGanadas;
	private Integer batallasPerdidas;

	public static SolucionXmen create(Map<Mutante, Mutante> batallas) {
		return new SolucionXmen(batallas);
	}

	private SolucionXmen(Map<Mutante, Mutante> batallas){
		this.batallas = new HashMap<Mutante, Mutante>();
		this.batallas.putAll(batallas);
		calculaPropiedadesDerivadas();		
	}
	
	private void calculaPropiedadesDerivadas(){
		this.batallasGanadas = 0;
		this.batallasPerdidas = 0;
		this.batallasPorMutante = new HashMap<>();
		for (Mutante mutante: batallas.keySet()){
			Mutante xmen = batallas.get(mutante);
			Integer puntuacionXmen = xmen.getSumaCaracteristicas();
			Integer puntuacionMutante  = mutante.getSumaCaracteristicas();
			if (puntuacionMutante > puntuacionXmen){
				batallasPerdidas++;
			}else if (puntuacionMutante < puntuacionXmen){
				batallasGanadas++;
			}
			if (!batallasPorMutante.containsKey(xmen))
				batallasPorMutante.put(xmen, 1);
			else
				batallasPorMutante.put(xmen, batallasPorMutante.get(xmen) + 1);
			
			if (!batallasPorMutante.containsKey(mutante))
				batallasPorMutante.put(mutante, 1);
			else
				batallasPorMutante.put(mutante, batallasPorMutante.get(mutante) + 1);
		}
	}
	
	public Map<Mutante, Integer> getBatallasPorMutante() {
		return batallasPorMutante;
	}

	public Map<Mutante, Mutante> getBatallas() {
		return batallas;
	}

	public Integer getBatallasGanadas() {
		return batallasGanadas;
	}

	public Integer getBatallasPerdidas() {
		return batallasPerdidas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batallas == null) ? 0 : batallas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolucionXmen other = (SolucionXmen) obj;
		if (batallas == null) {
			if (other.batallas != null)
				return false;
		} else if (!batallas.equals(other.batallas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SolucionXmen [batallasPorMutante=" + batallasPorMutante + ", batallas=" + batallas
				+ ", batallasGanadas=" + batallasGanadas + ", batallasPerdidas=" + batallasPerdidas + "]";
	}
	
	
		
}
