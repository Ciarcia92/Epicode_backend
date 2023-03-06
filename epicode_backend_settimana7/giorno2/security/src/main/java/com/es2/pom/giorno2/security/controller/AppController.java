package com.es2.pom.giorno2.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es2.pom.giorno2.security.entities.Gender;
import com.es2.pom.giorno2.security.entities.Person;

@RestController
@RequestMapping("/app")
public class AppController {

	@GetMapping("/data1")
	public String response() {
		return "response";
	}
	
	@GetMapping("/data2")
	public List<Person> people() {
		return new ArrayList<Person>() {{
			add(new Person(1, "mario", Gender.M));
			add(new Person(2, "tizio", Gender.F));
			add(new Person(3, "caio", Gender.F));
			add(new Person(3, "sempronio", Gender.M));
		}};
	}
	
	@GetMapping("/data3")
	public List<Person> people2() {
		return new ArrayList<Person>() {{
			add(new Person(4, "marietto", Gender.M));
			add(new Person(5, "tizietto", Gender.F));
			add(new Person(6, "caietto", Gender.F));
			add(new Person(7, "sempronietto", Gender.M));
		}};
	}

	
}
