package com.example.demo.BEAN;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component("ordine")
@Scope("prototype")
public class Ordine {

	
	List<Prodotto> elMenu;
	Tavolo tavolo;
	int numOrdine;
	StatoOrdine stato;
	int numCoperti;
	String ora;
	double costoCoperto;
	
	public Ordine(List<Prodotto> elMenu, Tavolo tavolo, int numOrdine, StatoOrdine stato, int numCoperti, String ora
		) {
		super();
		this.elMenu = elMenu;
		this.tavolo = tavolo;
		this.numOrdine = numOrdine;
		this.stato = stato;
		this.numCoperti = numCoperti;
		this.ora = ora;
		this.costoCoperto = 1.5;
	}
	
	public double costoTotale() {
		double i = costoCoperto * numCoperti;
		double costoTotale = 0;
		for(Prodotto p: elMenu) {
			costoTotale += p.getPrezzo();
		}
		return costoTotale + i;
	}
}
