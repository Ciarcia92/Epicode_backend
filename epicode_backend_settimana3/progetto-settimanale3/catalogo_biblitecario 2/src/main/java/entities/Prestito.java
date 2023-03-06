package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "prestiti")
@Getter
@Setter
public class Prestito {

	@Id
	@SequenceGenerator(name = "prestiti_seq", sequenceName = "prestiti_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prestiti_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "elemento_prestato_id")
	private ElementoLetterario elementoPrestato;


	@ManyToOne
	@JoinColumn(name = "utente_id")
	private Utente utente;

	
	@Column(name = "data_inizio_prestito")
	private LocalDate dataInizioPrestito;

	
	@Column(name = "data_restituzione_prevista")
	private LocalDate dataRestituzionePrevista;

	
	@Column(name = "data_restituzione_effettiva")
	private LocalDate dataRestituzioneEffettiva;


}
