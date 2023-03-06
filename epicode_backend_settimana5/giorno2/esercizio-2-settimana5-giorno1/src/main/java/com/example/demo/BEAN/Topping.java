package com.example.demo.BEAN;

import java.util.HashSet;
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

@AllArgsConstructor
@ToString
@Component("topping")
@Scope("prototype") 
public class Topping extends Alimentare{
	
	String tipo;
	
	public Topping() {
		
	}
	public Topping(double prezzo, int calorie,String nota, String tipo) {
        super(prezzo, calorie, nota);
        this.tipo = tipo;
	}
		
	public double getPrezzo() {
		return this.prezzo;
	}
}
