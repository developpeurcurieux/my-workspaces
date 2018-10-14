package com.easysoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.easysoft.dao.CommandeRepository;

@SpringBootApplication
public class EboutiqueApplication implements CommandLineRunner {

	@Autowired 
	private CommandeRepository commandeRepository; 
	
	
	public static void main(String[] args) {
		SpringApplication.run(EboutiqueApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
				
	}
}
