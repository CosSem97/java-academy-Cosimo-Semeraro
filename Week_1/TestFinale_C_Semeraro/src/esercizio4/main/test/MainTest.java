package esercizio4.main.test;

import esercizio4.fumetteria.*;

public class MainTest {

	public static void main(String[] args) {
		
		int n = 3;
		
		Fumetto f1 = new Fumetto("Fantastic", "Luca Perli", 2009, 30.9, "Editore1", "Fantasy", "Chiara Ivi");
		Fumetto f2 = new Fumetto("Wonder", "Carlo Carli", 2008, 9.9, "Editore2", "Fantasy", "Chiara Ivi");
		Fumetto f3 = new Fumetto("Astrology", "Marta Perli", 2000, 45, "Editore3", "World", "Simone Dorati");
		
		Fumetto[] arrayFumetti = {f1, f2, f3};
		
		Fumetteria fum = new Fumetteria("Fumetteria1", "via dei Verdi", "Luca Sicuri", 3, arrayFumetti);
		
		fum.stampaDati();
	}

}
