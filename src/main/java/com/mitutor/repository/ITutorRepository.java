package com.mitutor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mitutor.entities.Tutor;

@Repository
public interface ITutorRepository extends JpaRepository<Tutor, Integer> {
	@Query(value = "select t "
			+ "from Tutor t "
			+ "join t.subjects s "
			+ "where s.name = :subjectName")
	public List<Tutor> findBySubjectName(@Param("subjectName") String subjectName);
}