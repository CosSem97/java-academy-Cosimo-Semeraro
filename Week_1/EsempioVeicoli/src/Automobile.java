
public class Automobile extends Veicolo{
	
	private String targa;
	private String modello;
	
	
	
	
	public Automobile(String tipoVeicolo, int numTelaio, String targa, String modello) {
		super(tipoVeicolo, numTelaio);
		this.targa = targa;
		this.modello = modello;
	}
	
	

	public String getTarga() {
		return targa;
	}



	public void setTarga(String targa) {
		this.targa = targa;
	}



	public String getModello() {
		return modello;
	}



	public void setModello(String modello) {
		this.modello = modello;
	}


	@Override
	public void stampaDatiVeicolo() {
		
		System.out.println(this);
	}
	

	@Override
	public String toString() {
		return super.toString() + ", targa: " + this.targa + ", modello: " + this.modello;
	}
	
	
	
}
