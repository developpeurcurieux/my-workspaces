package com.easysoft.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Categorie implements Serializable {
	@Id
	@GeneratedValue
	private Long idCategorie;
	
	@NotEmpty
	@Size(min=4, max=20)
	private String nomCategorie;
	
	@Size(min=5)
	private String description;
	
	@Lob
	private byte[] photo;

	private String nomPhoto;
	
	@OneToMany(mappedBy="categorie")
	private Collection<Produit> produits;

	public Categorie(String nomCategorie, String description, byte[] photo, String nomPhoto) {
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.photo = photo;
		this.nomPhoto = nomPhoto;
	}
}
