package libreria;

public class Libreria {
	
	private String nome;
	private String partitaIva;
	private String indirizzo;
	private Dipendente amministratore;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public Dipendente getAmministratore() {
		return amministratore;
	}
	public void setAmministratore(Dipendente amministratore) {
		this.amministratore = amministratore;
	}
	
	

}
