package com.easysoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easysoft.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
