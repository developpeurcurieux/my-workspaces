package com.easysoft;

import java.util.Date;

import com.easysoft.dao.reposiotry.FormationRepository;
import com.easysoft.models.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.easysoft.dao.reposiotry.EtudiantRepository;
import com.easysoft.models.Etudiant;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class MsUh2cApplication implements CommandLineRunner {
	@Autowired
	private EtudiantRepository etudiantRepository;

	@Autowired
	private FormationRepository formationRepository;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(MsUh2cApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repositoryRestConfiguration.exposeIdsFor(Formation.class, Etudiant.class);

		Formation f1 = formationRepository.save(new Formation("PHP", 30));
		Formation f2 = formationRepository.save(new Formation("Java", 200));
		Formation f3 = formationRepository.save(new Formation("Oracle", 72));

		Etudiant e1 = new Etudiant("Hassan", "Khaled", new Date());
		e1.setFormation(f1);
		Etudiant e2 = new Etudiant("Mohamed", "ALi", new Date());
		e2.setFormation(f1);
		Etudiant e3 = new Etudiant("Omar", "CHouaib", new Date());
		e3.setFormation(f2);
		Etudiant e4 = new Etudiant("Loth", "Houd", new Date());
		e4.setFormation(f2);
		Etudiant e5 = new Etudiant("Mickael", "Houd", new Date());
		e5.setFormation(f3);

		etudiantRepository.save(e1);
		etudiantRepository.save(e2);
		etudiantRepository.save(e3);
		etudiantRepository.save(e4);
		etudiantRepository.save(e5);
	}


	
	
}
