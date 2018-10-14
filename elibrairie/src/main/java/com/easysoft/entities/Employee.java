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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String motDePasse;
	private String nom;
	private String prenom;
	private Date dateEntree;
	private Date dateSortie;
	private String email;
	private String grade;
	private String statut;
	private String champLibre;
}
