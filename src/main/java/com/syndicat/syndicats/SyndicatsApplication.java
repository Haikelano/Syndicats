package com.syndicat.syndicats;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SyndicatsApplication {
    @Autowired
		public static void main(String[] args) {
		SpringApplication.run(SyndicatsApplication.class, args);

	}

}
