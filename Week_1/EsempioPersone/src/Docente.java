
public class Docente extends Persona{
	
	protected String matD;
	private String uniD;
	
	public Docente(String codF, String nome, String cognome, String matD, String uniD) {
		
		super(codF, nome, cognome);
		this.matD = matD;
		this.uniD = uniD;
	}
	
	public String getMatD() {
		return matD;
	}
	
	public void setMatD(String matD) {
		this.matD = matD;
	}
	
	public String getUniD() {
		return uniD;
	}
	
	public void setUniD(String uniD) {
		this.uniD = uniD;
	}
		
		
		
	@Override
	public String toString() {
		return "Docente ---> " + super.toString() + super.codF + ", matricola: " + this.matD + ", università: " + this.uniD;
	}
}

