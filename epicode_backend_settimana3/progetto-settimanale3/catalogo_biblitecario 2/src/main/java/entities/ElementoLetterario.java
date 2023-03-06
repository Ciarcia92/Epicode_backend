package entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.SequenceGenerator;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@NamedQuery(name = "getByIsbn", query = "SELECT e FROM ElementoLetterario e WHERE e.ISBN = :ISBN")
@NamedQuery(name = "getByYear", query = "SELECT e FROM Libro e WHERE e.annoPubblicazione = :anno")
@NamedQuery(name = "getByAuthor", query = "SELECT l FROM Libro l WHERE l.autore = :autore")
@NamedQuery(name = "getByTitle", query = "SELECT e FROM Libro e WHERE e.titolo = :titolo")

public class ElementoLetterario {

	@Id
	@SequenceGenerator(name = "elementi_seq", sequenceName = "elementi_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "elementi_seq")
	private Long id;
	
	@Column(unique = true)
	private int ISBN;
	private int pagine;
	private String titolo;
	private int annoPubblicazione;
	
	public ElementoLetterario(Long id, int iSBN, int pagine, String titolo, int annoPubblicazione) {
		super();
		this.id = id;
		ISBN = iSBN;
		this.pagine = pagine;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
	}

	
	

	//SETTER
		public void setTitolo(String titolo) {
		  try {
	            if (titolo.length() < 2) {
	                throw new IllegalArgumentException("Il titolo deve cotenere almeno 2 caratteri");
	            }
	            this.titolo = titolo;
	        } catch (NullPointerException e) {
	            throw new IllegalArgumentException("il titolo ");
	        }
	    }
		
		public void setAnnoPubblicazione(int annoPubblicazione) {
		    if(annoPubblicazione <= 0) {
		        throw new IllegalArgumentException("l'anno di pubblicazione non può essere 0 o minore");
		    }
		    this.annoPubblicazione = annoPubblicazione;
		}

		public void setPagine(int pagine) {
			if(pagine<=0) {
				 throw new IllegalArgumentException("il numero di pagine deve essere superiore a 0");
				
			}
			this.pagine = pagine;	
			
		}

	
}
