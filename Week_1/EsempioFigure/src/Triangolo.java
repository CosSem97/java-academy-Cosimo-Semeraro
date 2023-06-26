
public class Triangolo extends Figura{
	
	private double b;
	private double h;
	
	protected double secondoLato;
	protected double terzoLato;
	
	
	
	public Triangolo(double b, double h, double secondoLato, double terzoLato) {
		
		this.b = b;
		this.h = h;
		this.secondoLato = secondoLato;
		this.terzoLato = terzoLato;
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
		
		return (b*h)/2;
	}
	
	@Override
	public double calcolaPerimetro() {
		
		return b + secondoLato + terzoLato;
	}
	
	
	
}
