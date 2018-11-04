package com.easysoft.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="commande_id")
    private Long commandeId;
    private Date dateCommande;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @OneToMany(mappedBy = "commande")
    private Collection<LigneCommande> ligneCommandes;

    public Commande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }
}
