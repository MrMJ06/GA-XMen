package ti3.xmen;

public class Mutante {

	private String nombre;
	private Integer fuerza;
	private Integer fuego;
	private Integer hielo;
	private Integer materia;
	private Integer numBatallas;
	private boolean esLider;
	private boolean esXmen;
	private int codigo;

	public Mutante(int codigo, boolean esXmen, String nombre, Integer fuerza, Integer fuego, Integer hielo, Integer materia, Integer numBatallas,
			boolean esLider) {
		super();
		this.codigo = codigo;
		this.esXmen = esXmen;
		this.nombre = nombre;
		this.fuerza = fuerza;
		this.fuego = fuego;
		this.hielo = hielo;
		this.materia = materia;
		this.numBatallas = numBatallas;
		this.esLider = esLider;
	}

	private Mutante(int codigo, String[] fm) {
		super();
		this.codigo = codigo;
		this.esXmen = new Boolean(fm[0]);
		this.nombre = fm[1];
		this.fuerza = new Integer(fm[2]);
		this.fuego = new Integer(fm[3]);
		this.hielo = new Integer(fm[4]);
		this.materia = new Integer(fm[5]);
		this.numBatallas = new Integer(fm[6]);
		this.esLider = new Boolean(fm[7]);
	}

	public static Mutante create(int codigo, boolean esXmen, String nombre, Integer fuerza, Integer fuego, Integer hielo, Integer materia,
			Integer numBatallas, boolean esLider) {
		return new Mutante(codigo, esXmen, nombre, fuerza, fuego, hielo, materia, numBatallas, esLider);
	}

	public static Mutante create(int codigo, String[] fm) {
		return new Mutante(codigo, fm);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getFuerza() {
		return fuerza;
	}

	public void setFuerza(Integer fuerza) {
		this.fuerza = fuerza;
	}

	public Integer getFuego() {
		return fuego;
	}

	public void setFuego(Integer fuego) {
		this.fuego = fuego;
	}

	public Integer getHielo() {
		return hielo;
	}

	public void setHielo(Integer hielo) {
		this.hielo = hielo;
	}

	public Integer getMateria() {
		return materia;
	}

	public void setMateria(Integer materia) {
		this.materia = materia;
	}

	public Integer getNumBatallas() {
		return numBatallas;
	}

	public void setNumBatallas(Integer numBatallas) {
		this.numBatallas = numBatallas;
	}

	public boolean isLider() {
		return esLider;
	}

	public void setLider(boolean esLider) {
		this.esLider = esLider;
	}
	
	

	public boolean isXmen() {
		return esXmen;
	}

	public void setXmen(boolean esXmen) {
		this.esXmen = esXmen;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Integer getSumaCaracteristicas(){
		return this.getFuego() + this.getFuerza() + this.getHielo() + this.getMateria();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + (esLider ? 1231 : 1237);
		result = prime * result + (esXmen ? 1231 : 1237);
		result = prime * result + ((fuego == null) ? 0 : fuego.hashCode());
		result = prime * result + ((fuerza == null) ? 0 : fuerza.hashCode());
		result = prime * result + ((hielo == null) ? 0 : hielo.hashCode());
		result = prime * result + ((materia == null) ? 0 : materia.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numBatallas == null) ? 0 : numBatallas.hashCode());
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
		Mutante other = (Mutante) obj;
		if (codigo != other.codigo)
			return false;
		if (esLider != other.esLider)
			return false;
		if (esXmen != other.esXmen)
			return false;
		if (fuego == null) {
			if (other.fuego != null)
				return false;
		} else if (!fuego.equals(other.fuego))
			return false;
		if (fuerza == null) {
			if (other.fuerza != null)
				return false;
		} else if (!fuerza.equals(other.fuerza))
			return false;
		if (hielo == null) {
			if (other.hielo != null)
				return false;
		} else if (!hielo.equals(other.hielo))
			return false;
		if (materia == null) {
			if (other.materia != null)
				return false;
		} else if (!materia.equals(other.materia))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numBatallas == null) {
			if (other.numBatallas != null)
				return false;
		} else if (!numBatallas.equals(other.numBatallas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nombre ;
	}

	public String toString2() {
		return "Mutante [nombre=" + nombre + ", fuerza=" + fuerza + ", fuego=" + fuego + ", hielo=" + hielo + ", materia="
				+ materia + ", numBatallas=" + numBatallas + ", esLider=" + esLider + ", esXmen=" + esXmen + ", codigo="
				+ codigo + "]";
	}
}
