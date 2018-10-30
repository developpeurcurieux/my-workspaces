/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.easysoft.dao;

import com.easysoft.dao.repository.CategorieRepository;
import com.easysoft.dao.repository.ProduitRepository;
import com.easysoft.entities.Categorie;
import com.easysoft.entities.Produit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kakashi
 */
@Repository
public class ProduitDaoImpl implements ProduitDao{
    
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private ProduitRepository produitRepository;
    
    @Override
    public String saveCategorie(Categorie categorie) {
        categorieRepository.save(categorie);
        return categorie.getCategorieId();
    }
    
    @Override
    public List<Categorie> listCategories() {
        return categorieRepository.findAll();
    }
    
    @Override
    public Categorie getCategorie(String categorieId) {
        return categorieRepository.getOne(categorieId);
    }
    
    @Override
    public void deleteCategorie(String categorieId) {
        categorieRepository.delete(categorieRepository.getOne(categorieId));
    }
    
    @Override
    public void updateCategorie(Categorie categorie) {
        categorieRepository.save(categorie);
    }
    
    @Override
    public String saveProduit(Produit produit, String categorieId) {
        Categorie categorie = categorieRepository.getOne(categorieId);
        produit.setCategorie(categorie);
        produitRepository.save(produit);
        return produit.getProduitId();
    }
    
    @Override
    public List<Produit> listProduits() {
        return produitRepository.findAll();
    }
    
    @Override
    public List<Produit> produitsParMotCle(String motCle) {
        return produitRepository.findByMotCle(motCle);
    }
    
    @Override
    public List<Produit> produitsParCategorie(String categorieId) {
        return produitRepository.findByCategorie(categorieId);
    }
    
    @Override
    public List<Produit> produitsSelectionnes() {
        return produitRepository.findSelected();
    }
    
    @Override
    public Produit getProduit(String produitId) {
        return produitRepository.getOne(produitId);
    }
    
    @Override
    public void deleteProduit(String produitId) {
        produitRepository.delete(produitRepository.getOne(produitId));
    }
    
    @Override
    public void updateProduit(Produit produit) {
        produitRepository.save(produit);
    }
    
}
