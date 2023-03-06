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
@Table(name="riviste")
@Getter
@Setter
@NoArgsConstructor

public class Rivista extends ElementoLetterario {
	
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;

	public Rivista(Periodicita periodicita) {
		super();
		this.periodicita = periodicita;
	}
	
	

}
