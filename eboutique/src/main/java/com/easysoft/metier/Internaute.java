package com.easysoft.metier;

import java.util.List;

import com.easysoft.entities.Categorie;
import com.easysoft.entities.Client;
import com.easysoft.entities.Commande;
import com.easysoft.entities.Panier;
import com.easysoft.entities.Produit;

public interface Internaute {
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCategorie);
	
	public List<Produit> listProduits();
	public List<Produit> produitsParMotCle(String motCle);
	public List<Produit> produitsParCategorie(Long idCategorie);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idProduit);
	
	public Commande enregistrerCommande(Panier panier, Client client);
}
