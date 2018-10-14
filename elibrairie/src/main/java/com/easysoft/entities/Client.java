package com.easysoft.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String genre;
	private String prenom;
	private String nom;
	private String email;
	private String motDePasse;
	private Date dateAdhesion;
	private String telephoneFixe;
	private String telephoneMobile;
	private String statut;
	private String champLibre;
}
