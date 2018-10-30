/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easysoft.metier;

import com.easysoft.entities.Categorie;
import com.easysoft.entities.Produit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easysoft.dao.ProduitDao;

/**
 *
 * @author kakashi
 */

@Service
public class ProduitMetierImpl implements ProduitMetier{

    @Autowired
    private ProduitDao dao;
    
    
    @Override
    public List<Categorie> listCategories() {
        return dao.listCategories();
    }

    @Override
    public Categorie getCategorie(String categorieId) {
        return dao.getCategorie(categorieId);
    }

    @Override
    public List<Produit> listProduits() {
        return dao.listProduits();
    }

    @Override
    public List<Produit> produitsParMotCle(String motCle) {
        return dao.produitsParMotCle(motCle);
    }

    @Override
    public List<Produit> produitsParCategorie(String categorieId) {
        return dao.produitsParCategorie(categorieId);
    }

    @Override
    public List<Produit> produitsSelectionnes() {
        return dao.produitsSelectionnes();
    }

    @Override
    public Produit getProduit(String produitId) {
        return dao.getProduit(produitId);
    }

    @Override
    public String saveProduit(Produit produit, String categorieId) {
       dao.saveProduit(produit, categorieId);
       return dao.getProduit(produit.getProduitId()).getProduitId();
    }

    @Override
    public void deleteProduit(String produitId) {
        dao.deleteProduit(produitId);
    }

    @Override
    public void updateProduit(Produit produit) {
        dao.updateProduit(produit);
    }

    @Override
    public String saveCategorie(Categorie categorie) {
       dao.saveCategorie(categorie);
       return dao.getCategorie(categorie.getCategorieId()).getCategorieId();
    }

    @Override
    public void deleteCategorie(String categorieId) {
        dao.deleteCategorie(categorieId);
    }

    @Override
    public void updateCategorie(Categorie categorie) {
        dao.updateCategorie(categorie);
    }
    
}
