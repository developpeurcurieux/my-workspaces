package com.easysoft.metier;

import com.easysoft.entities.Produit;

public interface AdminProduits extends Internaute {
	public Produit ajouterProduit(Produit produit, Long idCategorie);
	public void supprimerProduit(Long idProduit);
	public void modifierProduit(Produit produit);
}
