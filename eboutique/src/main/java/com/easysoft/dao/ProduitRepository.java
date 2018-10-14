package com.easysoft.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easysoft.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{
	@Query("select p from Produit p where p.designation like :x")
	public List<Produit> findByMotCle(@Param("x") String motCle);
	
	@Query("select p from Produit p where p.categorie.idCategorie = ?1")
	public List<Produit> findByCategorie(Long idCategorie);
	
	@Query("select p from Produit p where p.selected = true")
	public List<Produit> findSelected();
}
