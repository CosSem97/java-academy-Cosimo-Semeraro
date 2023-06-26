package mainTest;
import libreria.*;

public class MainTest {

	public static void main(String[] args) {

		Libreria l1 = new Libreria();
		
		l1.setNome("Libreria1");
		
		l1.setAmministratore(new Dipendente("Calo", "Carli", "CRLCARL97IBIHB90" , "via dei verdi" , 10190, "TO", "Italia", "d98790", "amministratore", 53000));

		System.out.println("Libreria: " + l1.getNome());
		System.out.println("Amministratore: ");
		l1.getAmministratore().stampaDatiAanagrafici();
	}

}
