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
@ToString
@Component("alimentare")
@Scope("prototype") 
public abstract class Alimentare extends Prodotto {

	int calorie;
	String nota;

	public Alimentare(double price, int calorie, String nota) {
	super(price);
	this.calorie= calorie;
	this.nota = null;
	}

}
