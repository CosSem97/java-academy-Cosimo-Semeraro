
public abstract class Veicolo {
	
	private String tipoVeicolo;
	private int numTelaio;
	
	
	public Veicolo(String tipoVeicolo, int numTelaio) {
		
		this.tipoVeicolo = tipoVeicolo;
		this.numTelaio = numTelaio;
	}


	public String getTipoVeicolo() {
		return tipoVeicolo;
	}


	public void setTipoVeicolo(String tipoVeicolo) {
		this.tipoVeicolo = tipoVeicolo;
	}


	public int getNumTelaio() {
		return numTelaio;
	}


	public void setNumTelaio(int numTelaio) {
		this.numTelaio = numTelaio;
	}
	
	public abstract void stampaDatiVeicolo();


	@Override
	public String toString() {
		return "Veicolo ---> " + this.tipoVeicolo + ", numTelaio: " + this.numTelaio;
	}
}
