package com.example.week.project.demo.week.project1.spring.entities;

import java.security.SecureRandom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="postazioni")
@ToString
@Builder
public class Postazione {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(nullable = false, unique = true)
	    private String codice;
	    
	    private String descrizione;
	    
	    @Enumerated(EnumType.STRING)
	    private Tipo tipo;
	    
	    @Column(nullable = false)
	    private int numMaxPartecipanti;
	    
	    @Enumerated(EnumType.STRING)
	    private  StatoPostazione statoPostazione;
	    
	    @ManyToOne
	    private Edificio edificio;
	    
	    public Postazione(String descrizione, Tipo tipo, int numMaxPartecipanti, StatoPostazione statoPostazione, Edificio edificio) {
	    	this.codice = generaCodice();
	    	this.descrizione = descrizione;
	    	this.tipo = tipo;
	    	this.numMaxPartecipanti = numMaxPartecipanti;
	    	this.statoPostazione = statoPostazione;
	    	this.edificio = edificio;
	    }

	    //metodo ausiliario per la generazione di un codice casuale
		 public static String generaCodice() {
			SecureRandom random = new SecureRandom();
			StringBuilder sb = new StringBuilder(); 
			
			for(int i=  0; i < 7; i++) {
				sb.append(random.nextInt(10));
			}
			return sb.toString();
		}
}
