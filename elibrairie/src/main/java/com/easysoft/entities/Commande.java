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
public class Commande {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date dateCommande;
	private Double remise;
	private String modePaiement;
	private String comIp;
	private String champLibre;
	private Date dateExpedition;
	private String numeroDeSuivi;
	
}
