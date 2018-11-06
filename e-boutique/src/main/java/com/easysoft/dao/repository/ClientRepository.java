package com.easysoft.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easysoft.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
