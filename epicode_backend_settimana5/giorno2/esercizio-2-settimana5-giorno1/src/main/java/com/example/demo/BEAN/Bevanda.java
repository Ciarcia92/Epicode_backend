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

@Component("bevanda")
@Scope("prototype") 
public class Bevanda extends Alimentare {

	String tipo;
	String quantita;
	String alcol;
	public Bevanda(double prezzo, int calorie,String nota, String tipo, String quantita) {
		super(prezzo, calorie, nota);
		this.quantita = quantita;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Bevanda [tipo=" + tipo + ", quantita=" + quantita + ", alcol=" + alcol + ", calorie=" + calorie
				+ ", prezzo=" + prezzo + ", getTipo()=" + getTipo() + ", getQuantita()=" + getQuantita()
				+ ", getAlcol()=" + getAlcol() + ", getCalorie()=" + getCalorie() + ", toString()=" + super.toString()
				+ ", getPrezzo()=" + getPrezzo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
