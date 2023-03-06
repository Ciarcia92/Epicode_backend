package entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.InheritanceType;


@Entity
@Table(name="libri")
@Getter
@Setter
@NoArgsConstructor

public class Libro extends ElementoLetterario {
	
	
	private String autore;
	
	@Enumerated(EnumType.STRING)
	private Genere genere;
	
	public Libro(String autore, Genere genere) {
		super();
		this.autore = autore;
		this.genere = genere;
	}


	

	//SETTER
	public void setAutore(String autore) {
		if(autore.length()<2) {
			throw new IllegalArgumentException("Il nome dell'autore deve avere almeno 2 caratteri!");
		}
			this.autore = autore;			
		
	}


	

}
