package it.epicode.esercizi.settimana2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random random = new Random();
		
		int[] array = new int[5];
		
		//genera numeri casuali e lli inserisce nell'array
		for(int i = 0; i< array.length; i++) {
			array[i] = random.nextInt(11);
		} 
		
		System.out.println(Arrays.toString(array));
		
		Scanner input = new Scanner(System.in);
		
		
		 while(true) {
			 System.out.println("inserisci una posizione a cui aggiungere un numero e 0 per uscire");
			 
			 int pos = input.nextInt();
			 
			 if(pos==0) {
				 break;
			 }
			 
			 try {
				 if(pos<1 || pos>array.length) {
					 throw new ArrayIndexOutOfBoundsException();
				 }
				 System.out.println("iserisci un numero");
				 
				 int val = input.nextInt();
				 array[pos-1] = val;
				 
			 } catch (ArrayIndexOutOfBoundsException e){
				 
				 System.out.println("inserisci un valore tra 1 e 5!");
				 
			 }
			 
			 System.out.println(Arrays.toString(array));
			 
		 }
		 input.close();
	}
	

}
