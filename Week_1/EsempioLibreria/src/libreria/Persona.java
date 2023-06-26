package libreria;

public abstract class Persona {
	
	private String nome;
	private String cognome;
	private String cf;
	private String via;
	private int cap;
	private String provincia;
	private String nazione;
	
	
	
	public Persona(String nome, String cognome, String cf, String via, int cap, String provincia, String nazione) {
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
		this.via = via;
		this.cap = cap;
		this.provincia = provincia;
		this.nazione = nazione;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getCf() {
		return cf;
	}



	public void setCf(String cf) {
		this.cf = cf;
	}



	public String getVia() {
		return via;
	}



	public void setVia(String via) {
		this.via = via;
	}



	public int getCap() {
		return cap;
	}



	public void setCap(int cap) {
		this.cap = cap;
	}



	public String getProvincia() {
		return provincia;
	}



	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}



	public String getNazione() {
		return nazione;
	}



	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	
	
	
	public abstract void stampaDatiAanagrafici();



	@Override
	public String toString() {
		return "nome: " + nome + ", cognome: " + cognome + ", cf: " + cf + ", via: " + via + ", cap: " + cap
				+ ", provincia: " + provincia + ", nazione: " + nazione;
	}
	
	
	
	
}
