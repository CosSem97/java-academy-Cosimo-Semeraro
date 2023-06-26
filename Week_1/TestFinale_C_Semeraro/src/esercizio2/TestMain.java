package esercizio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int voto = 0;
		int sommaVoti = 0;
		double mediaVoti = 0;
		int numVoti = 0;
		boolean valido = true;
		
		do {
			System.out.println("Inserisci un voto: ");
			
			// Gestisco l'eventuale eccezione
			try {
				voto = s.nextInt();
				s.nextLine();
				valido = true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Valore non numerico!");
				valido = false;
				s.nextLine(); // leggo e scarto la stampa efettuata
			}
			
			
			if(valido && (voto<18 || voto>30) && voto != -1) {
				System.out.println("valore inserito non corretto!"); // questa stampa non và fatta se voto = -1
			}
			else if(valido && voto != -1){
				sommaVoti += voto;
				numVoti++;
			}
			
			
		}while(voto != -1);
		
		
		mediaVoti = (double)sommaVoti/(double)numVoti;
		
		System.out.println("Media voti: " + mediaVoti);
		
		
		// chiudo lo Scanner
		s.close();

	}

}
