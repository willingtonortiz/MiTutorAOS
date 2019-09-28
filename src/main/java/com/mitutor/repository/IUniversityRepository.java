package com.mitutor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitutor.entities.University;

@Repository
public interface IUniversityRepository extends JpaRepository<University, Integer> {
	Optional<University> findByName(String name);
}
