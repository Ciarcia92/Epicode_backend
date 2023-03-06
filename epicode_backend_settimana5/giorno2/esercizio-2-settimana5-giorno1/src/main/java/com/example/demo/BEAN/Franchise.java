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
@Component
@Scope("prototype")
public class Franchise extends Prodotto {

	String articolo;
	
	public Franchise(double price, String articolo) {
		super(price);
		this.articolo = articolo;
	}
}
