package com.easysoft.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Map<Long, LigneCommande> items = new HashMap<>();
	
	public void addArticle(Produit produit, int quantite) {
		if(items.get(produit.getIdProduit()) == null) {
			LigneCommande ligneCommande = new LigneCommande();
			ligneCommande.setProduit(produit);
			ligneCommande.setQuantite(quantite);
			ligneCommande.setPrix(produit.getPrix());
		}
		else {
			LigneCommande ligneCommande = items.get(produit.getIdProduit());
			ligneCommande.setQuantite(ligneCommande.getQuantite() + quantite);
		}
	}
	
	public Collection<LigneCommande> getItems() {
		return items.values();
	}
	
	public double getTotal() {
		double total = 0;
		
		for(LigneCommande lc : items.values()) {
			total += lc.getPrix() * lc.getQuantite();
		}		
		return total;
	}
	
	public int getSize() {
		return items.size();
	}
	
	public void deleteItem(Long idProduit) {
		items.remove(idProduit);
	}
}
