package com.instagram.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instagram.demo.model.loginmodel;

@Repository
public interface loginrepository extends JpaRepository<loginmodel, Integer> {
	loginmodel findByUsername(String username);

}
