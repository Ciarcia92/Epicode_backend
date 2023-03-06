package it.epicode.esercizi.settimana2;

public class BancaException extends Exception{
	
	String message;

    BancaException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
