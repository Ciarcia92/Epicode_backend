package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="location")
@Getter
@Setter

public class Location {

	private Long id;
	private String nome;
	private String citta;
	
/*	private Long getId() {
		return id;
	}
	private void setId() {
		this.id = id;
	}
	private String getNome() {
		return nome;
	}
	private void setNome() {
		this.nome = nome;
	}
	private String getCitta() {
		return citta;
	}
	private void setCitta() {
		this.citta = citta;
	} */
	
}
