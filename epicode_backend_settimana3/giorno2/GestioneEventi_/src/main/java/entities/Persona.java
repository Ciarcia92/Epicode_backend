package entities;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import antlr.collections.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="persona")
@Getter
@Setter

public class Persona {

	@Id
	@SequenceGenerator(name = "persone_seq", sequenceName = "persone_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persone_seq")	
	private int id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate dataDiNascita;
	private Sesso sesso;
//	private List<Partecipazione> listaPartecipazioni = new ArrayList();
}
