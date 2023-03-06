package com.example.demo.BEAN;

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
@AllArgsConstructor
@ToString
@Component("pizza")
@Scope("prototype")
public class Pizza extends PizzaBase {

	Set<Topping> topping;

	public Pizza(int calorie,String nota, String tipo, Set<Topping> topping, PizzaSize size) {
		super(calorie, nota);
		this.tipo = tipo;
		this.topping = topping;
		this.size = size;
	}


	public void setPrezzo() {
		if (this.size == PizzaSize.STANDARD) {
			prezzo = 5.5;
		} else if (this.size == PizzaSize.FAMIGLIA) {
			prezzo = 5.5 + 4.15;
			calorie = calorie * 2;
		} else {
			prezzo = 5.5 - 2;
			calorie = calorie - 2;
		}
	}
	public double setPrezzoTotale() {
		if(topping.size() > 0 ) {
			for(Topping t: topping) {
				prezzo += t.getPrezzo();
			}
			return prezzo;
		} 
		return prezzo;
	}
}
