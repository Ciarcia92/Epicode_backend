package esercizio1giorno3;

import java.util.Scanner;

public class esercizio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 Scanner input = new Scanner(System.in);
		 
		 System.out.println("inserisci un numero da 0 a 3");
		 int num = input.nextInt();
			
			switch (num) {
			case 0:
		     	System.out.println("zero");
			break;
			case 1:
				System.out.println("uno");
				break;
			case 2:
				System.out.println("due");
				break;
			case 3:
				System.out.println("tre");
				break;
				default:
					System.out.println("errore");
			}
			
			input.close();
	}

	

	
	
}
