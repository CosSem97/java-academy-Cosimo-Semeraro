import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		String risp, op;
		int a, b;
		
		risp = "SI";
		
		
		
		
		while(risp.equalsIgnoreCase("SI")) {
			
			try {
				System.out.println("Inserisci a: ");
				a = s.nextInt();
				s.nextLine();
				
				System.out.println("Inserisci b: ");
				b = s.nextInt();
				s.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println("Valore non numerico!");
				continue;
			}
			
			
			
			System.out.println("Quale operazione?\n"
								+ "+ - addizione\n"
								+ "- - sottrazione\n"
								+ "* - moltiplicazione\n"
								+ "/ - divisione\n");
			op = s.nextLine();

			
			
			switch(op) {
				
				case "+":
					System.out.println("a+b = " + add(a, b));
					break;
			
			
				case "-":
					System.out.println("a-b = " + sub(a, b));
					break;
			
		
				case "*":
					System.out.println("a*b = " + mul(a, b));
					break;
			
	
				case "/":
					System.out.println("a/b = " + div(a, b));
					break;
				
				default:
					System.out.println("Operazione non valida!");
				}
			
			System.out.println("Vuoi fare un'altra operazione? (SI/NO): ");
			risp = s.nextLine();
		}
			
		
		
		s.close();

	}
	
	
	public static int add(int a, int b) {
		
		return a+b;
	}
	
	public static int sub(int a, int b) {
		
		return a-b;
	}

	public static int mul(int a, int b) {
	
		return a*b;
	}

	public static double div(int a, int b) {
	
		return (double)a/(double)b;
	}

}
