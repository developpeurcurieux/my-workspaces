package com.easysoft;

import com.easysoft.entities.Categorie;
import com.easysoft.entities.Produit;
import com.easysoft.metier.ProduitMetier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class ProduitBootApplication implements CommandLineRunner{
    
    @Autowired
    private ProduitMetier metier;
   
    
    
	public static void main(String[] args) {
		SpringApplication.run(ProduitBootApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        List<Produit> l01 = new ArrayList();
        List<Produit> l02 = new ArrayList();
        
        Categorie c01  = new Categorie("8898", "OrdianteursCat", "un ensemble de cat", null, "image.jpg", null);
        
        Produit p01 = new Produit("UUJR", "un simple", "description", 233.5, true, "imagePrdo.jpg", 34, "un simple commentaire", c01);
        Produit p02 = new Produit("UTTTTTJR", "un complique", "description", 233.5, true, "imagePrdo.jpg", 34, "un simple commentaire", c01);
      

        
        metier.saveCategorie(c01);
        metier.saveProduit(p01, c01.getCategorieId());
        metier.saveProduit(p02, c01.getCategorieId());
        
        l02.addAll(metier.listProduits());
   
        
       
        
        System.out.println("------ DEBUT -------");
        
        System.out.println("l01.size: " + l01.size());
        System.out.println("l02.size: " + l02.size());
       System.out.println((l01.size() + 2) == l02.size());
      
               System.out.println(metier.getProduit("UUJR").getProduitId());
       
        System.out.println("---- fin -----");
      
   
   
    }
        
        
}
