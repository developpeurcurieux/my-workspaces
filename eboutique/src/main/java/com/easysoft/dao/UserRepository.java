package com.easysoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easysoft.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
