package esercizio1giorno3;

import java.util.Scanner;

public class esercizio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.print("Lo split terminerà una volta inserita una :q ");
	            String parola = scanner.nextLine();

	            if (parola.equals(":q")) {
	                break;
	            }

	            String[] caratteri = parola.split("");
	            String caratteriSeparati = String.join(",", caratteri);
	            System.out.println(caratteriSeparati);
	        }
	        scanner.close();
	}

}
