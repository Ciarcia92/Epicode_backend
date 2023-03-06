package it.epicode.esercizi.settimana2.es3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {

	private static final String ENCODING = "utf-8";

	
	public static void Main(String[] args) {
	ArrayList<Presenza> presenze = new ArrayList<Presenza>();
	
	String fileName = "presenze.txt";
	
	File registro = new File(fileName);
	
	Scanner input = new Scanner(System.in);
	 
	
	
	System.out.println( "Dammi il nome e cognome del dipendete" );
	
	String nomi = input.nextLine();
	
	System.out.println("dammi le ore di assenza");
	
	int ore = input.nextInt();
	
	Presenza p = new Presenza(nomi, ore);
	
	//String p = p.nomeDipendente + @ + p.giorniAssenza;
	
	
	
	
		
		
	}	
		
	public void aggiungiPresenza(File f, String s) throws IOException  {
		FileUtils.writeStringToFile(f, s, ENCODING);
	}
		
		
	}

/////////////////////////////////////////////////


class Presenza {
    String nomeDipendente;
    int giorniAssenza;

    public Presenza(String nome, int giorni) {
        this.nomeDipendente = nome;
        this.giorniAssenza = giorni;
    }
}



