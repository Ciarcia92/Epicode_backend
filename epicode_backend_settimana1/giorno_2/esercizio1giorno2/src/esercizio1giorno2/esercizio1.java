package esercizio1giorno2;

public class esercizio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rettangolo rettangolo = new Rettangolo(2, 3);

		System.out.println("il perimetro è: " + rettangolo.perimeter());

		Rettangolo r = new Rettangolo(4, 5);
		r.stampaRettangolo();
		Rettangolo r1 = new Rettangolo(2, 4);
		Rettangolo r2 = new Rettangolo(3, 4);

		r1.stampaDueRettangoli(r1, r2);

	}

}
