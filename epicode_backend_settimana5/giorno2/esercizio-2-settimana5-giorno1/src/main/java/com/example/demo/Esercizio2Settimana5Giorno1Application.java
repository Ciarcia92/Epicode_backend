package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.BEAN.Bevanda;
import com.example.demo.BEAN.Franchise;
import com.example.demo.BEAN.Ordine;
import com.example.demo.BEAN.Pizza;
import com.example.demo.BEAN.PizzaBase;
import com.example.demo.BEAN.PizzaSize;
import com.example.demo.BEAN.Prodotto;
import com.example.demo.BEAN.StatoOrdine;
import com.example.demo.BEAN.StatoTavolo;
import com.example.demo.BEAN.Tavolo;
import com.example.demo.BEAN.Topping;

@SpringBootApplication
public class Esercizio2Settimana5Giorno1Application {

	public static void main(String[] args) {
		SpringApplication.run(Esercizio2Settimana5Giorno1Application.class, args);
		menu();
	}

	private static void menu() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.example.demo.BEAN");
		ctx.refresh();
		
		Topping t1 = (Topping)ctx.getBean("topping", 3.00, 300, "nota", "formaggio");
		Topping t2 = (Topping)ctx.getBean("topping", 2.00, 200, "nota", "ananas");
		PizzaBase p = (PizzaBase)ctx.getBean("pizzabase", 400, "nota");
		Pizza p1 = (Pizza)ctx.getBean("pizza", 500, "nota", "hawaian", new HashSet<>(){{
			add(t1);
			add(t2);
		}}, PizzaSize.FAMIGLIA);	
		p1.setPrezzoTotale();
		
		Bevanda d1 = (Bevanda)ctx.getBean("bevanda", 3, 150, "nota", "Coca-cola", "33cl");
		Bevanda d2 = (Bevanda)ctx.getBean("bevanda", 5, 300, "nota", "becks", "33cl");
		Bevanda d3 = (Bevanda)ctx.getBean("bevanda", 3, 150, "nota", "Fanta", "33cl");
		d2.setAlcol("5%");
		
		 Franchise f1 = (Franchise)ctx.getBean("franchise", 15, "maglietta");
         Franchise f2 = (Franchise)ctx.getBean("franchise", 30, "felpa");
 
         Tavolo t5 = (Tavolo)ctx.getBean("tavolo", 1, 5, StatoTavolo.LIBERO);
         Tavolo t6 = (Tavolo)ctx.getBean("tavolo", 2, 3, StatoTavolo.OCCUPATO);
         Tavolo t3 = (Tavolo)ctx.getBean("tavolo", 3, 3, StatoTavolo.LIBERO);
         Tavolo t4 = (Tavolo)ctx.getBean("tavolo", 4, 2, StatoTavolo.OCCUPATO);
         
         Ordine o1 = (Ordine)ctx.getBean("ordine", new ArrayList<Prodotto>() {{
        	 add(p1);
        	 add(d1);
         }}, t5, 1, StatoOrdine.PRONTO,5, "12:05");
         Ordine o2 = (Ordine)ctx.getBean("ordine", new ArrayList<Prodotto>() {{
        	 add(p1);
        	 add(p1);
        	 add(d1);
        	 add(d2);
         }}, t4,  2, StatoOrdine.PRONTO,5, "13");
         
         System.out.println("                                   Menù");
 		System.out.println("-------------------------------------------------------------------------------");
 	
 		System.out.println("Pizza base: " + p.getTipo() + " calorie: " + p.getCalorie() + " prezzo: " + p.getPrezzo());
		System.out.println("Pizza: " + p1.getTipo() + " calorie: " + p1.getCalorie() + " prezzo: " + (p1.getPrezzo() + t2.getPrezzo()));
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("drinks                                           quantities          Price");
		System.out.println(d1.getTipo() + "                                               " + d1.getQuantita() + "             " + d1.getPrezzo()+"€");
		System.out.println(d2.getTipo() + "                                               " + d2.getQuantita() + "             " + d2.getPrezzo()+"€");
		System.out.println(d3.getTipo() + "                                               " + d3.getQuantita() + "             " + d3.getPrezzo()+"€");
    	System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Franchise                                                   Price");
	    System.out.println(f1.getArticolo() + "                                                     " + f1.getPrezzo()+"€");
        System.out.println(f2.getArticolo() + "                                                        " + f2.getPrezzo()+"€");
    	System.out.println("-------------------------------------------------------------------------------");
    	 System.out.println("L'ordine n: " + o1.getNumOrdine() + " con stato " + o1.getStato() + " costa " + o1.costoTotale()+"€");
         System.out.println("L'ordine n: " + o2.getNumOrdine() + " con stato " + o2.getStato() + " costa " + o2.costoTotale()+"€");
 		
         ctx.close();
	}
	
	
//	public static void menu() {
//		System.out.println("                                   Menù");
//		System.out.println("-------------------------------------------------------------------------------");
//		System.out.println("Pizze                                            quantities          Price");
//		makePizza();
//		System.out.println("-------------------------------------------------------------------------------");
//
//		System.out.println("drinks                                           quantities          Price");
//		makeBevande();
//		System.out.println("-------------------------------------------------------------------------------");
//
//		System.out.println("Franchise                                                   Price");
//		makeFranchise();
//	}
//	
//
//	public static void makePizza() {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		ctx.scan("com.example.demo.BEAN");
//		ctx.refresh();
//		
//		Topping t1 = (Topping)ctx.getBean("topping", 3.00, 300, "nota", "formaggio");
//		Topping t2 = (Topping)ctx.getBean("topping", 2.00, 200, "nota", "ananas");
//		PizzaBase p = (PizzaBase)ctx.getBean("pizzabase", 400, "nota");
//		Pizza p1 = (Pizza)ctx.getBean("pizza", 500, "nota", "hawaian", new HashSet<>(){{
//			add(t1);
//			add(t2);
//		}}, PizzaSize.FAMIGLIA);
//		
//		p1.setPrezzo();
//		System.out.println("Pizza base: " + p.getTipo() + " calorie: " + p.getCalorie() + " prezzo: " + p.getPrezzo());
//		System.out.println("Pizza: " + p1.getTipo() + " calorie: " + p1.getCalorie() + " prezzo: " + (p1.getPrezzo() + t2.getPrezzo()));
//		ctx.close();
//	}
//	
//	public static void makeBevande() {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		ctx.scan("com.example.demo.BEAN");
//		ctx.refresh();
//		Bevanda d1 = (Bevanda)ctx.getBean("bevanda", 3, 150, "nota", "Coca-cola", "33cl");
//		Bevanda d2 = (Bevanda)ctx.getBean("bevanda", 5, 300, "nota", "becks", "33cl");
//		Bevanda d3 = (Bevanda)ctx.getBean("bevanda", 3, 150, "nota", "Fanta", "33cl");
//		d2.setAlcol("5%");
//		System.out.println(d1.getTipo() + "                                               " + d1.getQuantita() + "             " + d1.getPrezzo()+"€");
//		System.out.println(d2.getTipo() + "                                               " + d2.getQuantita() + "             " + d2.getPrezzo()+"€");
//		System.out.println(d3.getTipo() + "                                               " + d3.getQuantita() + "             " + d3.getPrezzo()+"€");
//		ctx.close();
//	}
//
//	private static void makeFranchise() {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.scan("com.example.demo.BEAN");
//        ctx.refresh();
//        Franchise f1 = (Franchise)ctx.getBean("franchise", 15, "maglietta");
//        Franchise f2 = (Franchise)ctx.getBean("franchise", 30, "felpa");
//        System.out.println(f1.getArticolo() + "                                                     " + f1.getPrezzo()+"€");
//        System.out.println(f2.getArticolo() + "                                                        " + f2.getPrezzo()+"€");
//	
//	}
//


}


