package com.example.demo.BEAN;

import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component("tavolo")
@Scope("prototype")
public class Tavolo {

	int numero;
	int numCoperti;
	StatoTavolo stato;
}
