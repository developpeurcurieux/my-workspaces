package com.easysoft.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Livre {
	@Id
	private String isbn;
	private String edition;
	private Date dateEdition;
	private String resume;
	private Double prix;
	private Integer stock;
	private String photo;
	private String sousTitre;
	private String statut;
	private String champLibre;
}
