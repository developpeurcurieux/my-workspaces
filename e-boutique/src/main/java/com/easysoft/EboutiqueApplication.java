package com.easysoft;

import com.easysoft.entities.Categorie;
import com.easysoft.entities.Produit;
import com.easysoft.metier.AdminCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EboutiqueApplication implements CommandLineRunner {

	@Autowired 
	private AdminCategories metier;
	
	
	public static void main(String[] args) {
		SpringApplication.run(EboutiqueApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Categorie c01 = new Categorie("Ordinateurs", "pc portable", null, "image1.jpg");
		Categorie c02 = new Categorie("Imprimantes", "pc portable", null, "image2.jpg");
		Categorie c03 = new Categorie("Accessoires", "pc portable", null, "image3.jpg");
		
		
		Produit p01 = new Produit();
		p01.setDesignation("Dell XPS13");
		p01.setDescription("ordinateur pour Dev");
		p01.setPrix(1599);
		p01.setSelected(false);
		p01.setPhoto("dellXPS.jpg");
		p01.setQuantite(12);
		
		metier.ajouterCategorie(c01);
		metier.ajouterCategorie(c02);
		metier.ajouterCategorie(c03);
		
		
		metier.ajouterProduit(p01, c01.getIdCategorie());
		
		//System.out.println(metier.getCategorie(c01.getIdCategorie()));
		Produit p02 = metier.getProduit(p01.getIdProduit());
		System.out.println(p02.getDesignation());

	}
}
