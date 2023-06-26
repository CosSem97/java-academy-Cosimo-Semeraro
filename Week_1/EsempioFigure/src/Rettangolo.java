
public class Rettangolo extends Figura{
	
	private double b;
	private double h;
	
	
	
	public Rettangolo(double b, double h) {
		this.b = b;
		this.h = h;
	}
	
	
	public double getB() {
		return b;
	}


	public void setB(double b) {
		this.b = b;
	}


	public double getH() {
		return h;
	}


	public void setH(double h) {
		this.h = h;
	}


	@Override
	public double calcolaArea() {
		
		return this.b*this.h;
	}
	
	@Override
	public double calcolaPerimetro() {
		
		return (this.b+this.h)*2;
	}
	
	
}
