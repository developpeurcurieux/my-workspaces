package com.easysoft.dao.reposiotry;

import com.easysoft.models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    public List<Etudiant> findByNomContains(String nom);
}
