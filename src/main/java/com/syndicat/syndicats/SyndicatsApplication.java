package com.syndicat.syndicats;

import com.syndicat.syndicats.dao.UserRepository;
import com.syndicat.syndicats.entity.User;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.text.SimpleDateFormat;

@SpringBootApplication
public class SyndicatsApplication implements CommandLineRunner {
    @Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SyndicatsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
    userRepository.save(new User("haykel","maaoui","12/01/1994","haykel@gmail.com",53681254,"rien"));
    userRepository.save(new User("gasen","gasen","12/01/1994","haykel@gmail.com",53681254,"rien"));

    userRepository.findAll().forEach(c->
	{
		System.out.println(c.getNom());
	});


	}
}
