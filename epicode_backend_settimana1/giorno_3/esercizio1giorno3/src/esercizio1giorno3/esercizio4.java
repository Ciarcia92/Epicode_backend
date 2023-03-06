package esercizio1giorno3;

import java.util.Scanner;

public class esercizio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner (System.in);
		
	        System.out.println("inserisci un numero:");
	        
	        int numero = scanner.nextInt();
	        
	        for(int i = numero; i >= 0; i--) {
	            System.out.println(i);
	        }
	        scanner.close();
}
	
}
