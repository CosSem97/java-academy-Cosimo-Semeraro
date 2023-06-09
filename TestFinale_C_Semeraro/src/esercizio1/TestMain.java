package esercizio1;

public class TestMain {

	public static void main(String[] args) {
		
		int[] arr = {547, 87, 1, 24, 4, 9, 54, 37, 26, 19};
		
		System.out.println("Media degli elementi dell'array: " + calcolaMedia(arr));
		

	}
	
	
	
	public static double calcolaMedia(int[] arr) {
		
		// Verifico che arr non sia null
		if(arr == null) {
			System.out.println("Array null");
			return -1;
		}
		
		double somma = 0;
		
		for(int i = 0; i<arr.length; i++) {
			somma += arr[i];
		}
		
		return somma/arr.length;
	}

}
