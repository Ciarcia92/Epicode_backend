package it.epicode.esercizi.settimana2.giorno2.es2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OrderedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ordinaNumeri();

	}

	public static void ordinaNumeri() {

		Scanner input = new Scanner(System.in);

		System.out.println("inserisci un numero");

		int n = input.nextInt();

		List<Integer> numeri = new ArrayList<Integer>();

		Random random = new Random();

		for (int i = 0; i < n; i++) {
			
			numeri.add(random.nextInt(101));

			// ordina i numeri
			Collections.sort(numeri);
		}

		System.out.println(numeri);
		invertiOrdine(numeri);
	}

	private static void invertiOrdine(List<Integer> numeri) {

		// inverte l'ordine dei numeri
		Collections.reverse(numeri);

		System.out.println(numeri);

		Scanner sc = new Scanner(System.in);

		System.out.println("inserisci vero o falso");

		boolean bn = sc.nextBoolean();

		pariDispari(numeri, bn);
	}

	private static void pariDispari(List<Integer> numeri, boolean bn) {
		for (int i = 0; i < numeri.size(); i++) {
			if (bn == true) {
				if (i % 2 == 0) {
					System.out.println(numeri.get(i));
				}
			} else if (i % 2 != 0) {
				System.out.println(numeri.get(i));
			}
		}

	}
}
