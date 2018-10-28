/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easysoft.dao.repository;

import com.easysoft.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kakashi
 */
@Repository
public interface CategorieRepository extends JpaRepository<Categorie, String>{
    
}
