package com.mycompany;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mycompany.dao.EtudiantRepository;
import com.mycompany.entities.Etudiant;

@SpringBootApplication
public class MsUh2cApplication implements CommandLineRunner{
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MsUh2cApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		etudiantRepository.save(new Etudiant(null, "Samir", "Hassan", new Date()));
		etudiantRepository.save(new Etudiant(null, "Leslie", "toty", new Date()));
		etudiantRepository.save(new Etudiant(null, "Samira", "Houssam", new Date()));
		etudiantRepository.save(new Etudiant(null, "Leila", "fouad", new Date()));
		etudiantRepository.save(new Etudiant(null, "Nathalie", "jwt", new Date()));
		
	}
}
