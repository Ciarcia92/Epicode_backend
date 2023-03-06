package it.epicode.esercizi.settimana2.giorno2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	stampa();
	}

	
	public static void stampa() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("inserisci il numero di parole da inserire");
	
		int num = input.nextInt();	
		
	/*	try {
		} catch (NumberFormatException e){
			System.out.println("inserire un numero");
		} */
		
		Set<String> parole = new HashSet<String>();
	
		Set<String> paroleDuplicate = new HashSet<String>();
		
		for(int i = 0; i< num; i++) {
			System.out.println("inserisci la parola " + (i+1) + ":");
			
			String parola = input.next();
			
			if(parole.contains(parola)) {
				paroleDuplicate.add(parola);
			}
			parole.add(parola);
		
				
		}
		
		System.out.println("parole duplicate: " + paroleDuplicate);
		System.out.println("numero di parole duplicate: " + parole.size()); 
		System.out.println("elenco delle parole: " + parole);
	}
}
