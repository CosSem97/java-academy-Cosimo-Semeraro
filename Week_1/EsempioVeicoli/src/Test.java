import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		
		Automobile a1 = new Automobile("auto", 390, "AB 978 CD", "Berlina");
		Automobile a2 = new Automobile("auto", 391, "BB 978 CD", "Berlina");
		Automobile a3 = new Automobile("auto", 392, "CB 978 CD", "Berlina");
		Automobile a4 = new Automobile("auto", 393, "DB 978 CD", "Berlina");
		
		Automobile[] array = {a1, a2, a3, a4};
		
		System.out.println(array);
		System.out.println(Arrays.toString(array));
		
		for(Automobile a : array) {
			System.out.println(a);
			a.setNumTelaio(a.getNumTelaio()+1);
		}
		
		System.out.println(Arrays.toString(array));

	}

}

