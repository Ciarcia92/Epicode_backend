package esercizio1giorno2;

public class Rettangolo {

	private int width;
	private int height;

	public Rettangolo(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int perimeter() {
		return 2 * (width + height);
	}

	public int area() {
		return width * height;
	}

	void stampaRettangolo() {
		System.out.println("perimetro:" + perimeter());
		System.out.println("area:" + area());
	}

	void stampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
		int perimetro1 = r1.perimeter();
		int area1 = r1.area();
		int perimetro2 = r2.perimeter();
		int area2 = r2.area();
		System.out.println("il perimetro di r1 è:" + perimetro1);
		System.out.println("la area di r1 è:" + area1);
		System.out.println("il perimetro di r2 è:" + perimetro2);
		System.out.println("area di r2 è:" + area2);
		System.out.println("la somma dei perimetri è:" + (perimetro1 + perimetro2));
		System.out.println("la somma delle aree è:" + (area1 + area2));
	}
}
