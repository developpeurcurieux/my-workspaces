/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easysoft.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Categorie implements Serializable{
    @Id
    private String categorieId;
    
    @NotEmpty
    @Size(min=4, max=20)
    @Column(name="cat_nom")
    private String nom;
    
    @Size(min=8)
    @Column(name="cat_designation")
    private String description;
    
    
    private String photo;
    
    @Column(name="cat_photo")
    private String nomPhoto;
    
    @JsonManagedReference
    @OneToMany(mappedBy="categorie")
    private Collection<Produit> produits;
}
