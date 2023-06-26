
public class Quadrato extends Rettangolo{
	
	public Quadrato(double l) {
		
		super(l,l);
	}
	
	public double getLato() {
		return this.getB();
	}
}
