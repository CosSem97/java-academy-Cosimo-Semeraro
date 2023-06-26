
public class Studente extends Persona{
	
	private String matS;
	private String uniS;
	
	public Studente(String codF, String nome, String cognome, String matS, String uniS) {
		
		super(codF, nome, cognome);
		this.matS = matS;
		this.uniS = uniS;
	}

	public String getMatS() {
		return matS;
	}

	public void setMatS(String matS) {
		this.matS = matS;
	}

	public String getUniS() {
		return uniS;
	}

	public void setUniS(String uniS) {
		this.uniS = uniS;
	}
	
	
	
	@Override
	public String toString() {
		return "Studente ---> " + super.toString() + ", matricola: " + this.matS + ", università: " + this.uniS;
	}
}

