package com.easysoft.entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Etudiant implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue
	private Long id;
        
        @Column(name="nom", length = 25)
	private String nom;
        
        @Temporal(TemporalType.DATE)
	private Date dateNaissance;
        private String email;
	private String photo;			
}
	