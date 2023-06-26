package esercizio3.mainTest;

import esercizio3.implementazione.*;

public class MainTest {

	public static void main(String[] args) {
		
		Calciatore c = new Calciatore("Carlo", "Verdi", 1989, "Torino", "Real Madrid",
									  "Attaccante", 3099709, 3, 180000);
		
		c.stampaDati();
		System.out.println("Stipendio mensile: " + c.calcolaStipendioMensile() + " $");
	}

}
