
public class Calcolatrice {

	private int a, b;
	
	public Calcolatrice(int a, int b) {
		
		this.a = a;
		this.b = b;
	}
	
	

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	public int somma() {
		
		return this.a+this.b;
	}
	
	public int molt() {
		
		return this.a*this.b;
	}

	public double div() {
		if(this.b == 0)
			return -1;
		else
			return (double)this.a/(double)this.b;
	}

	public int sottr() {
	
		return this.a-this.b;
	}
}
