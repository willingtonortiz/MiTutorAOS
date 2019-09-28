package com.mitutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitutor.entities.Authority;

@Repository
public interface IAuthorityRepository extends JpaRepository<Authority, Integer> {
	
}
