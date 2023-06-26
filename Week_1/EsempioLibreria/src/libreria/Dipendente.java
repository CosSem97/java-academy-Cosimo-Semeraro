package libreria;

public class Dipendente extends Persona{

	
	private String matricola;
	private String ruolo;
	private double stipendio;
	
	
	public Dipendente(String nome, String cognome, String cf, String via, int cap, String provincia,
					  String nazione, String matricola, String ruolo, double stipendio) {
		
		super(nome, cognome, cf, via, cap, provincia, nazione);
		this.matricola = matricola;
		this.ruolo = ruolo;
		this.stipendio = stipendio;
	}


	public String getMatricola() {
		return matricola;
	}


	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}


	public String getRuolo() {
		return ruolo;
	}


	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}


	public double getStipendio() {
		return stipendio;
	}


	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}


	@Override
	public void stampaDatiAanagrafici() {
		
		System.out.println(super.toString() + ", matricola: " + this.matricola + ", ruolo: " + this.ruolo + ", stipendio: " + this.stipendio);
		
	}
	
	
	
	

}
