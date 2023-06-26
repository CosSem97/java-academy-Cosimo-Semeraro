
public class Test {

	public static void main(String[] args) {
		
		Persona p1 = new Persona("ANDCRL97SSAHJA89", "Andrea", "Carli");
		Persona s1 = new Studente("CRLCRL97SSAHJA89", "Carlo", "Ancona", "s395689", "PoliTo");
		Persona d1 = new Docente("CHRCRL97SSAHJA89", "Chiara", "Verdi", "d975689", "PoliBa");
		
		System.out.println(p1);
		System.out.println(s1);
		System.out.println(d1);
		
		
	}
	
	
	public static int prova(int x, int y) {
		
		return 3;
	}
	
public static int prova(double x, int y) {
		
		return 3;
	}

public static int prova(int x, String y) {
	
	return 3;
}

}
