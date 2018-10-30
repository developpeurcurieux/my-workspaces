/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easysoft.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author kakashi
 */

@Entity
@Table(name="produits")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produit implements Serializable{
    @Id
    private String produitId;

    @NotEmpty
    @Size(min=4, max=15)
    @Column(name="prod_designation")
    private String designation;

    @Column(name="prod_description")
    private String description;

    @Column(name="prod_prix")
    private double prix;
    
    @Column(name="prod_selected")
    private boolean selected;
    
    @Column(name="prod_photo")
    private String photo;
    
    @Column(name="prod_quantite")
    private int quantite;
    
    @Column(name="prod_commentaire")
    private String commentaire;
            
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="categorie_id")
    private Categorie categorie;
}
