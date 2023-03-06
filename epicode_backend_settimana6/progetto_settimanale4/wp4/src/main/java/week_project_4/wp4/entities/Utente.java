package week_project_4.wp4.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String fullname;
	private String username;
	private String email;
	private String password;
	
	@JsonIgnore
	@OneToMany
	private Set<Dispositivo> dispositivi;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "utente_ruolo",
		joinColumns = @JoinColumn(name = "utente_id"),
		inverseJoinColumns = @JoinColumn(name = "ruolo_id")
	)
	private Set<Ruolo> ruoli = new HashSet<>();
	
}