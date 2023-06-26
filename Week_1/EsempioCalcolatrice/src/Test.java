
public class Test {

	public static void main(String[] args) {
		
		int num1 = 9;
		int num2 = 10;
		
		Calcolatrice c = new Calcolatrice(num1, num2);
		
		System.out.println("Addizione: " + c.somma());
		System.out.println("Moltiplicazione: " + c.molt());
		System.out.println("Divisione: " + c.div());
		System.out.println("Sottrazione: " + c.sottr());
		
		c.setA(3);
		c.setB(5);
		System.out.println("Addizione: " + c.somma());
		System.out.println("Moltiplicazione: " + c.molt());
		System.out.println("Divisione: " + c.div());
		System.out.println("Sottrazione: " + c.sottr());

	}

}
