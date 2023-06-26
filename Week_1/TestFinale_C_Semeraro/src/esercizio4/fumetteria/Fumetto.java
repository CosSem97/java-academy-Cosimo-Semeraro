package esercizio4.fumetteria;

public class Fumetto extends Libro{
	
	private String nome;
	private String disegnatore;
	
	// --- costruttore ---
	public Fumetto(String titolo, String autore, int annoPub, double costo, String editore, String nome, String disegnatore) {
		
		// costruttore della superclasse Libro
		super(titolo, autore, annoPub, costo, editore);
		
		this.nome = nome;
		this.disegnatore = disegnatore;
		
	}

	
	// --- metodi get e set ---
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDisegnatore() {
		return disegnatore;
	}

	public void setDisegnatore(String disegnatore) {
		this.disegnatore = disegnatore;
	}


	@Override
	public String toString() {
		return "Fumetto:\n"
				+ super.toString()
				+ ",\n- nome: " + nome
				+ ",\n- disegnatore: " + disegnatore;
	}
	
	
	
	
	
	
	
	
	
}
