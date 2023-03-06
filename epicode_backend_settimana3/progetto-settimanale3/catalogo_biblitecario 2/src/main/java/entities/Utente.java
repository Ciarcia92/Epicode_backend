package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="utenti")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Utente {
	
	
	@Id
	@SequenceGenerator(name = "utenti_seq", sequenceName = "utenti_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utenti_seq")
	private Long id;
	
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	
	@Column(name= "numero_tessera", unique = true)
	private int numTessera;
	
	@OneToMany(mappedBy = "utente")
	private Set<Prestito> prestiti;
	

    @Override 
    public String toString() {
    	return "utente " + id + ", nome: " + nome + ", cognome: " + cognome + ", nato il: " + dataNascita + ", numero tessera: " + numTessera;
    }


}
