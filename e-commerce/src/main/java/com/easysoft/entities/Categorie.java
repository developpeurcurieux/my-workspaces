package com.easysoft.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@NoArgsConstructor
@Data
@Entity
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categorie_id")
    private Long categorieId;

    @NotEmpty
    @Size(min=4, max=20)
    private String nom;

    @NotEmpty
    @Size(min=4)
    private String description;
    private String nomPhoto;

    @Lob
    private byte[] photo;

    @OneToMany(mappedBy = "categorie")
    private Collection<Produit> produits;

    public Categorie(String nom, String description, String nomPhoto, byte[] photo) {
        this.nom = nom;
        this.description = description;
        this.nomPhoto = nomPhoto;
        this.photo = photo;
    }
}
