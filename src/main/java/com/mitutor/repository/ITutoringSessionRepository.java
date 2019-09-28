package com.mitutor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mitutor.entities.TutoringSession;

@Repository
public interface ITutoringSessionRepository extends JpaRepository<TutoringSession, Integer> {

	@Query("select ts from TutoringSession ts where ts.subject.name = :subjectName")
	List<TutoringSession> findBySubjectName(@Param("subjectName") String subjectName);
}
