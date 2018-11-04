package com.easysoft.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@Data
@Entity
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produit_id")
    private Long produitId;

    @NotEmpty
    @Size(min=4, max=15)
    private String designation;

    @Size(min=4, max=15)
    private String description;
    private double prix;
    private boolean selected;
    private String nomPhoto;
    private int quantite;

    @ManyToOne
    @JoinColumn(name="categorie_id")
    private Categorie categorie;

    public Produit(String designation, String description, double prix, boolean selected, String nomPhoto, int quantite) {
        this.designation = designation;
        this.description = description;
        this.prix = prix;
        this.selected = selected;
        this.nomPhoto = nomPhoto;
        this.quantite = quantite;
    }
}
