/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easysoft.dao.repository;

import com.easysoft.entities.Produit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kakashi
 */
@Repository
public interface ProduitRepository extends JpaRepository<Produit, String>{
    @Query("select p from Produit p where p.designation like :x")
    public List<Produit> findByMotCle(@Param("x") String motCle);
    
    @Query("select p from Produit p where p.categorie.categorieId = :x")
    public List<Produit> findByCategorie(@Param("x") String categorieId);
    
    @Query("select p from Produit p where p.selected = true")
    public List<Produit> findSelected();
}
