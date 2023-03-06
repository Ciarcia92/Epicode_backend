package it.epicode.esercizi.settimana2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in) ;
		
		int km;
		int l;
		try {
			System.out.println("inserisci i km percorsi");
			km = Integer.parseInt(input.nextLine());
			
			System.out.println("inserisci i litri di carburante consumati");
			l = Integer.parseInt(input.nextLine());	
			
			consumoCarburante(km, l);
			
			//System.out.println("i km al litro percorsi sono: " + consumoCarburante(km, l));

		} catch  ( NumberFormatException a) {
			System.out.println("Devi inserire un numero!");	
		}
	
	}

	private static void consumoCarburante(int km, int l) {
		
		int consumo;
		
		try {
			consumo = km/l;
		/*	if(km==0) {
				throw new ArithmeticException();
			}*/
			System.out.println(consumo);
			
			} catch (ArithmeticException e) {
			
				System.out.println("i l non possono essere uguali a 0");
				
		    } 
	}

}

