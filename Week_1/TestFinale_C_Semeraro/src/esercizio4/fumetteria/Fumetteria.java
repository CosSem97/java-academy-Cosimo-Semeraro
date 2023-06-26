package esercizio4.fumetteria;

import java.util.Arrays;

public class Fumetteria {
	
	private String nome;
	private String via;
	private String titolare;
	private int numFumettiMax;
	private Fumetto[] fumetti;
	
	
	// --- costruttore ---
	public Fumetteria(String nome, String via, String titolare, int numFumettiMax, Fumetto[] fumetti) {
		
		this.nome = nome;
		this.via = via;
		this.titolare = titolare;
		this.numFumettiMax = numFumettiMax;
		this.fumetti = fumetti;
	}
	
	
	
	// --- metodi get e set ---
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getTitolare() {
		return titolare;
	}

	public void setTitolare(String titolare) {
		this.titolare = titolare;
	}

	public int getNumFumettiMax() {
		return numFumettiMax;
	}

	public void setNumFumettiMax(int numFumettiMax) {
		this.numFumettiMax = numFumettiMax;
	}

	public Fumetto[] getFumetti() {
		return fumetti;
	}

	public void setFumetti(Fumetto[] fumetti) {
		this.fumetti = fumetti;
	}
	
	
	public void stampaDati() {
		
		System.out.println(this);
	
		
		System.out.println("Lista dei fumetti:");
		
		for(Fumetto fum : fumetti) {
			System.out.println(fum); // richiama in automatico il metodo toString() di Fumetto
		}
	}



	@Override
	public String toString() {
		return "Fumetteria:\n"
				+ "nome: " + nome
				+ ",\n- via: " + via
				+ ",\n- titolare: " + titolare
				+ ",\n- numFumettiMax: " + numFumettiMax;
				
	}
	
	
	
	
	
}
