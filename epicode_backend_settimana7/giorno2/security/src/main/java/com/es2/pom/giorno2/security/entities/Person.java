package com.es2.pom.giorno2.security.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* Realizzare un servizio Spring Boot attivo sulla porta 8082 che espone i seguenti endpoint GET:
/app/data1   -> response
/app/data2 -> responselist di arraylist di 4 persone
/app/data3 -> arraylist di 4 persone
Realizzare un servizio Spring Boot attivo sulla porta 8081 che espone i seguenti endpoint:
/os/get-string    contatta :8082/app/data1 e stampa il responso
/os/get-people contatta :8082/app/data3 e stampa il responso
/os/get-people-json contatta :8082/app/data3 e produci il responso JSON
Opzionalmente, proteggere le route tramite autenticazione.
Opzionalmente, agganciare un front-end tramite Live Server e contattare :8082/app/data3 per stampare in console il risultato JSON (occorre abilitare il CORS sul back-end).
Questo è l'esercizio di oggi che sostituisce quello in piattaforma.
@RequestMapping(value = "/data3", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private int id;
	private String fullname;
	private Gender gender;
	
}
