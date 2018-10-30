/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.easysoft.dao;

import com.easysoft.entities.Categorie;
import com.easysoft.entities.Produit;
import java.util.List;

/**
 *
 * @author kakashi
 */
public interface ProduitDao {
    public String saveCategorie(Categorie categorie);
    public List<Categorie> listCategories();
    public Categorie getCategorie(String categorieId);
    public void deleteCategorie(String categorieId);
    public void updateCategorie(Categorie categorie);
    
    public String saveProduit(Produit produit, String categorieId);
    public List<Produit> listProduits();
    public List<Produit> produitsParMotCle(String motCle);
    public List<Produit> produitsParCategorie(String categorieId);
    public List<Produit> produitsSelectionnes();
    public Produit getProduit(String produitId);
    public void deleteProduit(String produitId);
    public void updateProduit(Produit produit);
}
