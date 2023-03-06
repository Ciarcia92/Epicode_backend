package it.epicode.esercizi.settimana2.giorno2.es3;

import java.util.HashMap;

public class Rubrica {

	static HashMap<String, String> rubrica = new HashMap<>();
	
	public static void main(String[] args) {
		inserisciContatto("ciro", "3405428384");
		inserisciContatto("peppe", "34052328384");
		inserisciContatto("gennaro", "34054276984");
		inserisciContatto("carmine", "34054282434");
		
	/*	System.out.println(rubrica);

		cancellaContatto("ciro");
		
	    cercaPersona("34052328384");
		
		
		
		System.out.println(rubrica);
		
		System.out.println(cercaNumero("carmine")); */
		System.out.println("contatti");
		stampaContatti();
		
		System.out.println("-------------------------------");
		System.out.println("contatti dopo eliminazione");
		cancellaContatto("ciro");
		stampaContatti();
	}

	

	private static void inserisciContatto(String nome, String valore) {
		rubrica.put(nome, valore);
	}
	
	private static void cancellaContatto(String nome) {
        rubrica.remove(nome);
    }
	/*
	public static void cercaPersona(String valore) {
        for(HashMap.Entry mEntry : rubrica.entrySet()){
            if(mEntry.getValue().equals(valore)) {
                System.out.println(mEntry.getKey());
            }
        }
    } 
	*/
	 public static String cercaNumero(String nome) {
	        return rubrica.get(nome);
	    }
	 
	 public static String cercaPersona(String numero) {
	        for (String nome : rubrica.keySet()) {
	            if (rubrica.get(nome).equals(numero)) {
	                return nome;
	            }
	        }
	        return null;
	    }

	    public static void stampaContatti() {
	        for (String nome : rubrica.keySet()) {
	            System.out.println(nome + ": " + rubrica.get(nome));
	        }
	   } 
	    
}
