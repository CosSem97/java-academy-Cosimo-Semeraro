

public class Persona {
	
	protected String codF;
	protected String nome;
	protected String cognome;
	
	
	
	public Persona(String codF, String nome, String cognome) {
		
		this.codF = codF;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	
	public String getCodF() {
		return codF;
	}


	public void setCodF(String codF) {
		this.codF = codF;
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

	
	@Override
	public String toString() {
		return this.nome + " " + this.cognome + " --- codice fiscale: " + this.codF;
	}
	
}
