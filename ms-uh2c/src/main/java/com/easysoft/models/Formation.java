package com.easysoft.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@NoArgsConstructor
@Data
@Entity
public class Formation {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private int duree;

    @OneToMany(mappedBy = "formation")
    private Collection<Etudiant> etudiants;

    public Formation(String nom, int duree) {
        this.nom = nom;
        this.duree = duree;
    }
}
