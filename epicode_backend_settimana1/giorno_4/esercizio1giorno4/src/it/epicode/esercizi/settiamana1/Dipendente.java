package it.epicode.esercizi.settiamana1;

public class Dipendente {

	private static double stipendioBase = 1000;
	private int matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;
	
	
	//COSTRUTTORI
	 public Dipendente(int matricola, Dipartimento dipartimento) {
	        this.matricola = matricola;
	        this.dipartimento = dipartimento;
	        this.stipendio = stipendioBase;
	        this.importoOrarioStraordinario = 30;
	        this.livello = Livello.OPERAIO;
	    }
	 
	  public Dipendente(int matricola, Dipartimento dipartimento, double stipendio, double importoOrarioStraordinario, Livello livello) {
	        this.matricola = matricola;
	        this.dipartimento = dipartimento;
	        this.stipendio = stipendio;
	        this.importoOrarioStraordinario = importoOrarioStraordinario;
	        this.livello = livello;
	    }
	  
	  
	  // GETTERS
	  public int getMatricola() {
		  return matricola;
	  }
	  
	  public double getStipendio() {
		  return stipendio;
	  }
	  public double getImportoOrarioStraordinario() {
		  return importoOrarioStraordinario;
	  }
	  public Livello getLivello() {
		  return livello;
	  }
	  public Dipartimento getDipartimento() {
		  return dipartimento;
	  }
	  
	  //SETTERS
	  public void setDipartimento(Dipartimento dipartimento) {
		  this.dipartimento = dipartimento;
	  }
	  public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		  this.importoOrarioStraordinario = importoOrarioStraordinario;
	  }
	  
	  //FUNZIONI
	  public void stampaDatiDipendente() {
		  System.out.printf("Dipendente: %n - Matricola: %d: %n - Stipendio: %.1f %n - Importo orario straordinario: %.2f %n - Livello: %s %n - Dipartimento: %s %n",
				  this.matricola, this.stipendio, this.importoOrarioStraordinario, this.livello, this.dipartimento);
		  
		/*  System.out.println("Dipendente: ");
		  System.out.println("Matricola: " + this.matricola);
		 System.out.println("Stipendio: " + this.stipendio);
		  System.out.println("Importo orario straordinario:  " + this.importoOrarioStraordinario);
		  System.out.println("Livello: " + this.livello);
		 System.out.println("Dipartimento: " + this.dipartimento);
		 System.out.println("-----------------------------");
	  */
	  }
	  
	 public void promuovi() {
		  if(livello == Livello.OPERAIO) {
			  livello = Livello.IMPIEGATO;
			  stipendio = stipendioBase * 1.2;
		  } else if(livello == Livello.IMPIEGATO) {
			  livello = Livello.QUADRO;
			  stipendio = stipendioBase * 1.5;
		  } else if(livello == Livello.QUADRO) {
			  livello = Livello.DIRIGENTE;
			  stipendio = stipendioBase * 2;
		  } else if(livello == Livello.DIRIGENTE) {
			  System.out.println("Errore");
		  }
		  
		  System.out.println("livello: " + livello);
		  System.out.println("-----------------------------");
	  }
	 
	 public static double calcolaPaga(Dipendente dipendente) {
		 
		 return dipendente.getStipendio();
	 }
	 
	 
	public static double calcolaPaga(Dipendente dipendente, int oreStraordinario) {
		double stipendio = dipendente.getStipendio();
		double straordinario = dipendente.getImportoOrarioStraordinario();
	    stipendio += (straordinario * oreStraordinario);
	//	System.out.println("stipendio" + stipendio);
	//	System.out.println("-----------------------------");
		return stipendio;
	 }
	 
	 
	  
}
