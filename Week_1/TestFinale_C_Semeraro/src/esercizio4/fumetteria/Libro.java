package esercizio4.fumetteria;

public class Libro {
	
	// --- attributi ---
	private String titolo;
	private String autore;
	private int annoPub;
	private double costo;
	private String editore;
	
	
	// --- costruttore ---
	public Libro(String titolo, String autore, int annoPub, double costo, String editore) {
		
		this.titolo = titolo;
		this.autore = autore;
		this.annoPub = annoPub;
		this.costo = costo;
		this.editore = editore;
	}


	
	// --- metodi get e set ---
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getAnnoPub() {
		return annoPub;
	}

	public void setAnnoPub(int annoPub) {
		this.annoPub = annoPub;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) {
		this.editore = editore;
	}



	@Override
	public String toString() {
		return "titolo: " + this.titolo
				+ ",\n- autore: " + this.autore
				+ ",\n- annoPub: " + this.annoPub
				+ ",\n- costo: " + this.costo
				+ ",\n- editore: " + this.editore;
	}
	
}
