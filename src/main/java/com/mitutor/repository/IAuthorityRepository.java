package com.mitutor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitutor.entities.Authority;

@Repository
public interface IAuthorityRepository extends JpaRepository<Authority, Integer> {
	Optional<Authority> findByAuthority(String authority);
}
