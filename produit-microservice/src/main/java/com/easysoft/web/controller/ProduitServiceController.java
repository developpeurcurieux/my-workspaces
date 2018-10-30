/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easysoft.web.controller;

import com.easysoft.entities.Categorie;
import com.easysoft.entities.Produit;
import com.easysoft.metier.ProduitMetier;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kakashi
 */
@RestController
@RequestMapping("/v1/produit-service")
public class ProduitServiceController {
    
    private static final Logger LOG = LoggerFactory.getLogger(ProduitServiceController.class);
    
    @Autowired
    private ProduitMetier metier;
    
    @GetMapping("/produits")
    public List<Produit> getProduits() {
        return metier.listProduits();
    }
    
    @GetMapping("/categories")
    public List<Categorie> getCategories() {
        return metier.listCategories();
    }
    
    @GetMapping("/produit/{produitId}")
    public Produit getProduitById(@PathVariable("produitId") String produitId) {
        return metier.getProduit(produitId);
    }
    
    @PostMapping("/produits/{categorieId}/produits")
    public void saveProduit(@PathVariable("categorieId") String categorieId, @RequestBody Produit produit) {
        LOG.info("Produit with id: " + produit.getProduitId() + ", and categorieId: " + categorieId + " added");
        metier.saveProduit(produit, categorieId);
    }
}
