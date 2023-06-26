
public class TriangoloRettangolo extends Triangolo{
	
	public TriangoloRettangolo(double b, double h)
	{
		super(b, h, h, Math.sqrt(b*b + h*h));	
	}
	
	public double getLato() {
		
		return this.getB();
	}
}
