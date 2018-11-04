package com.easysoft.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Data
@Entity
public class LigneCommande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantite;
    private double prix;

    @ManyToOne
    @JoinColumn(name="produit_id")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name="commande_id")
    private Commande commande;

    public LigneCommande(int quantite, double prix, Produit produit) {
        this.quantite = quantite;
        this.prix = prix;
        this.produit = produit;
    }
}
