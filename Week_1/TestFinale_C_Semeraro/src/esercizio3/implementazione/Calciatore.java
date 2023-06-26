package esercizio3.implementazione;

import esercizio3.interfaccia.GiocatoreProfessionista;
import java.time.LocalDate;




public class Calciatore implements GiocatoreProfessionista{
	
	// --- attributi ---
	private String nome;
	private String cognome;
	private int annoNascita;
	private String luogoNascita;
	private String squadra;
	private String ruolo;
	private double costoCartellino;
	private int anniContratto;
	private double stipendioAnnuo;
	
	
	
	// --- costruttore ---
	public Calciatore(String nome, String cognome, int annoNascita, String luogoNascita,
					  String squadra, String ruolo, double costoCartellino, int anniContratto,
					  double stipendioAnnuo) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.annoNascita = annoNascita;
		this.luogoNascita = luogoNascita;
		this.squadra = squadra;
		this.ruolo = ruolo;
		this.costoCartellino = costoCartellino;
		this.anniContratto = anniContratto;
		this.stipendioAnnuo = stipendioAnnuo;
	}
	
	
	// --- metodi get e set ---
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

	public int getAnnoNascita() {
		return annoNascita;
	}

	public void setAnnoNascita(int annoNascita) {
		this.annoNascita = annoNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getSquadra() {
		return squadra;
	}

	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public double getCostoCartellino() {
		return costoCartellino;
	}

	public void setCostoCartellino(double costoCartellino) {
		this.costoCartellino = costoCartellino;
	}

	public int getAnniContratto() {
		return anniContratto;
	}

	public void setAnniContratto(int anniContratto) {
		this.anniContratto = anniContratto;
	}

	public double getStipendioAnnuo() {
		return stipendioAnnuo;
	}

	public void setStipendioAnnuo(double stipendioAnnuo) {
		this.stipendioAnnuo = stipendioAnnuo;
	}	
	
	
	
	// --- override del metodo toString() ---
	@Override
	public String toString() {
		return "Calciatore:\n"
				+ "- nome: " + this.nome
				+ ",\n- cognome: " + this.cognome
				+ ",\n- annoNascita: " + this.annoNascita
				+ ",\n- luogoNascita: "+ this.luogoNascita
				+ ",\n- squadra: " + this.squadra
				+ ",\n- ruolo: " + this.ruolo
				+ ",\n- costoCartellino: " + this.costoCartellino + " $"
				+ ",\n- anniContratto: " + this.anniContratto
				+ ",\n- stipendioAnnuo: " + this.stipendioAnnuo + " $";
	}
	
	
	
	// --- implementazione dei metodi d'interfaccia ---
	@Override
	public void stampaDati() {
		
		System.out.println(this); 	// richiama in automatico il metodo this.toString()
	}
	
	@Override
	public double calcolaStipendioMensile() {
		
		return this.stipendioAnnuo/12;
	}


	
	
	
	
	
	
}
