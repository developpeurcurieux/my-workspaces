package com.easysoft.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable {
    private Map<Long, LigneCommande> items = new HashMap<>();

    public void addItem(Produit produit, int quantite) {
        if(items.get(produit.getProduitId()) == null) {
            LigneCommande ligneCommande = new LigneCommande();
            ligneCommande.setProduit(produit);
            ligneCommande.setQuantite(quantite);
            ligneCommande.setPrix(produit.getPrix());
        }
        else {
            LigneCommande ligneCommande = items.get(produit.getProduitId());
            ligneCommande.setQuantite(ligneCommande.getQuantite() + quantite);
        }
    }

    public Collection<LigneCommande> getItems() {
        return items.values();
    }

    public double getTotal() {
        double total = 0;
        for(LigneCommande ligneCommande : items.values()) {
            total += ligneCommande.getPrix() * ligneCommande.getQuantite();
        }
        return total;
    }

    public int getSize() {
        return items.size();
    }

    public void deleteItem(Long produitId) {
        items.remove(produitId);
    }
}
