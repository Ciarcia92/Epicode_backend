package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="partecipazioni")
@Getter
@Setter

public class Partecipazione {

	@Id

	private Long id;
	private Persona persona;
	private Evento evento;
	private Stato stato;
	

}
