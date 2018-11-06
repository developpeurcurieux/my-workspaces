package com.easysoft.dao;

import java.util.List;
import java.util.Optional;

import com.easysoft.entities.Categorie;
import com.easysoft.entities.Client;
import com.easysoft.entities.Commande;
import com.easysoft.entities.Panier;
import com.easysoft.entities.Produit;
import com.easysoft.entities.Role;
import com.easysoft.entities.User;

public interface BoutiqueDao {
	public Categorie ajouterCategorie(Categorie categorie);
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCategorie);
	public void supprimerCategorie(Long idCategorie);
	public void modifierCategorie(Categorie categorie);
	
	public Produit ajouterProduit(Produit produit, Long idCategorie);
	public List<Produit> listProduits();
	public List<Produit> produitsParMotCle(String motCle);
	public List<Produit> produitsParCategorie(Long idCategorie);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idProduit);
	public void supprimerProduit(Long idProduit);
	public void modifierProduit(Produit produit);
	
	public void ajouterUser(User user);
	public void attribuerRole(Role role, Long idUser);
		
	public Commande enregistrerCommande(Panier panier, Client client);
	
	
}
