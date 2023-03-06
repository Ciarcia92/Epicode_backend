package com.es2.pom.giorno2.sicurezza.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/os")
public class AppController {

	
	@GetMapping("/get-string")
	  public String response() {

        RestTemplate rt = new RestTemplate();
        String rtUrl = "http://localhost:8081/app/data1";
        String response = rt.getForObject(rtUrl, String.class);
        return response;

	}
        @GetMapping("/get-people")
        public String people2() {

            RestTemplate rt = new RestTemplate();
            String rtUrl = "http://localhost:8081/app/data2";
            String response = rt.getForObject(rtUrl, String.class);
            return "people list: " + response;
       }
        
        @CrossOrigin(origins = "http://127.0.0.1:5500")
        @RequestMapping(value = "/get-people-json", method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_VALUE)
        public Object people2Json() {
            RestTemplate rt = new RestTemplate();
            String rtUrl = "http://localhost:8081/app/data3";
            Object response = rt.getForObject(rtUrl, Object.class);
            return response;

        }
}
