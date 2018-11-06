package com.easysoft.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Produit implements Serializable {
	@Id
	@GeneratedValue
	private Long idProduit;
	
	@NotEmpty
	@Size(min=4, max=15)
	private String designation;
	private String description;
	private double prix;
	private boolean selected;
	private String photo;
	private int quantite;
	
	@ManyToOne
	@JoinColumn(name="ID_CAT")
	private Categorie categorie;

	public Produit(String designation, String description, double prix, boolean selected, String photo, int quantite) {
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.selected = selected;
		this.photo = photo;
		this.quantite = quantite;
	}
}
