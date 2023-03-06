package com.example.demo.BEAN;

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

@Component("pizzabase")
@Scope("prototype") 
public class PizzaBase extends Alimentare{
	
	String tipo;
	PizzaSize size;
	
	public PizzaBase(int calorie, String nota) {
		super(calorie, nota);
		this.prezzo = 5.5;
		this.tipo = "margherita(pomodoro, mozzarella";
		this.size= PizzaSize.STANDARD;
	}

	
}
