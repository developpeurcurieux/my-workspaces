package com.easysoft.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.easysoft.dao.BoutiqueDao;
import com.easysoft.entities.Categorie;
import com.easysoft.entities.Client;
import com.easysoft.entities.Commande;
import com.easysoft.entities.Panier;
import com.easysoft.entities.Produit;
import com.easysoft.entities.Role;
import com.easysoft.entities.User;

public class BoutiqueMetierImpl implements AdminCategories {
	
	@Autowired
	private BoutiqueDao dao;
		
	@Override
	public Long ajouterProduit(Produit produit, Long idCategorie) {
		return dao.ajouterProduit(produit, idCategorie);
	}
 
	@Override
	public void supprimerProduit(Long idProduit) {
		dao.supprimerProduit(idProduit);
	}

	@Override
	public void modifierProduit(Produit produit) {
		dao.modifierProduit(produit);
	}

	@Override
	public List<Categorie> listCategories() {
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCategorie) {
		return dao.getCategorie(idCategorie);
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
	public List<Produit> produitsParCategorie(Long idCategorie) {
		return dao.produitsParCategorie(idCategorie);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		return dao.produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idProduit) {
		return dao.getProduit(idProduit);
	}

	@Override
	public Commande enregistrerCommande(Panier panier, Client client) {
		return dao.enregistrerCommande(panier, client);
	}

	@Override
	public Long ajouterCategorie(Categorie categorie) {
		return dao.ajouterCategorie(categorie);
	}

	@Override
	public void supprimerCategorie(Long idCategorie) {
		dao.supprimerCategorie(idCategorie);
	}

	@Override
	public void modifierCategorie(Categorie categorie) {
		dao.modifierCategorie(categorie);		
	}

	@Override
	public void ajouterUser(User user) {
		dao.ajouterUser(user);
	}

	@Override
	public void attribuerRole(Role role, Long idUser) {
		dao.attribuerRole(role, idUser);
	}
	
}
