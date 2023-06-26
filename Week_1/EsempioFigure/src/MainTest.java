
public class MainTest {

	public static void main(String[] args) {
		
		Figura[] array = new Figura[4];
		
		array[0] = new Rettangolo(9,7);
		array[1] = new Quadrato(3);
		array[2] = new Triangolo(3, 4, 8, 9);
		array[3] = new TriangoloRettangolo(3, 3.2);
		
		for(Figura fig : array) {
			fig.stampaRisultati();
		}

	}

}
