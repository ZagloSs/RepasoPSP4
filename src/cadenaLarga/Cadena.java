package cadenaLarga;

public class Cadena {
	private String cadena;
	private String quien;
	
	public Cadena(String cadena, String quien) {
		super();
		this.cadena = cadena;
		this.quien = quien;
	}

	public synchronized String getCadena() {
		return cadena;
	}

	public synchronized void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public synchronized String getQuien() {
		return quien;
	}

	public synchronized void setQuien(String quien) {
		this.quien = quien;
	}
	
	
	
	
}
