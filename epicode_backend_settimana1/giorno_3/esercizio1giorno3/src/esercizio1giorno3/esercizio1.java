package esercizio1giorno3;

import java.util.Scanner;

public class esercizio1 {

	public static void main(String[] args) {
		
		 Scanner input = new Scanner(System.in);

	
		 System.out.println("inserisci una stringa");
		 String string = input.nextLine();
		 int length = string.length();
		   
		 if (length % 2 == 0) {
				System.out.println("true");
		 } else {
			 System.out.println("false");
		 }
				System.out.println("inserisci un numero");
				
				
				
				//anno bisestile
		 int anno = input.nextInt();
		 input.close();
		 if(anno % 100 == 0 && anno % 400 == 0) {
				System.out.println("true");
		 } else {
			 System.out.println("false");
		 }
		 
				
	}
	


}
