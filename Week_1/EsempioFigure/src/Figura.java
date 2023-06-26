
public abstract class Figura {
	
	public abstract double calcolaArea();
	public abstract double calcolaPerimetro();
	
	
	
	public void stampaRisultati() {
		
		System.out.println("area: " + this.calcolaArea() + ", perimetro: " + this.calcolaPerimetro());
	}
}
