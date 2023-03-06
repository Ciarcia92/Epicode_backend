package it.epicode.esercizi.settimana2.es1;

public class Threads extends Thread {


	String simbolo;
	
	public Threads(String simbolo) {
		this.simbolo = simbolo;
	}

	public static void main(String[] args) {
		
		
		Threads t1 = new Threads("*");
		Threads t2 = new Threads("#");

		t1.start();
		
		t2.start();
	}

	
	
	public void runSimbolo() {
		for(int i = 0; i<10; i++) {
			System.out.println("simbolo: " + simbolo);
	
		try {
			Threads.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		}
	}
	
	@Override
	public void run() {
		this.runSimbolo();
	}

}
