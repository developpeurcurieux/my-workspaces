package com.easysoft.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.easysoft.dao.BoutiqueDao;

import com.easysoft.dao.repository.CategorieRepository;
import com.easysoft.dao.repository.ClientRepository;
import com.easysoft.dao.repository.CommandeRepository;
import com.easysoft.dao.repository.LigneCommandeRepository;
import com.easysoft.dao.repository.ProduitRepository;
import com.easysoft.dao.repository.UserRepository;

import com.easysoft.entities.Categorie;
import com.easysoft.entities.Client;
import com.easysoft.entities.Commande;
import com.easysoft.entities.LigneCommande;
import com.easysoft.entities.Panier;
import com.easysoft.entities.Produit;
import com.easysoft.entities.Role;
import com.easysoft.entities.User;

import org.springframework.stereotype.Repository;

@Repository
public class BoutiqueDaoImpl implements BoutiqueDao {
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private ProduitRepository produitRepository; 
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public Categorie ajouterCategorie(Categorie categorie) {
		categorieRepository.save(categorie);
		return categorieRepository.findById(categorie.getIdCategorie()).get();
	}

	@Override
	public List<Categorie> listCategories() {
		return categorieRepository.findAll();
	}

	@Override
	public Categorie getCategorie(Long idCategorie) {
		return categorieRepository.getOne(idCategorie);
	}

	@Override
	public void supprimerCategorie(Long idCategorie) {
		categorieRepository.delete(categorieRepository.getOne(idCategorie));
	}

	@Override
	public void modifierCategorie(Categorie categorie) {
		categorieRepository.save(categorie);		
	}

	@Override
	public Produit ajouterProduit(Produit produit, Long idCategorie) {
		Categorie categorie = categorieRepository.findById(idCategorie).get();
		produit.setCategorie(categorie);
		produitRepository.save(produit);
		return new Produit();
		//return produitRepository.findById(produit.getIdProduit()).get();
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
	public List<Produit> produitsParCategorie(Long idCategorie) {
		return produitRepository.findByCategorie(idCategorie);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		return produitRepository.findSelected();
	}

	@Override
	public Produit getProduit(Long idProduit) {
		return produitRepository.getOne(idProduit);
	}

	@Override
	public void supprimerProduit(Long idProduit) {
		produitRepository.delete(produitRepository.getOne(idProduit));
	}

	@Override
	public void modifierProduit(Produit produit) {
		produitRepository.save(produit);
	}

	@Override
	public void ajouterUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void attribuerRole(Role role, Long idUser) {
		User user = userRepository.getOne(idUser);
		user.getRoles().add(role);
		userRepository.save(user);
	}

	@Override
	public Commande enregistrerCommande(Panier panier, Client client) {
		clientRepository.save(client);
		
		Commande commande = new Commande();
		commande.setDateCommande(new Date());
		commande.setItems(panier.getItems());
		
		for(LigneCommande ligneCommande : panier.getItems()) {
			ligneCommandeRepository.save(ligneCommande);
		}
		
		commandeRepository.save(commande);
		return commande;		 
	}
}
