package com.mitutor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mitutor.entities.Topic;

@Repository
public interface ITopicRepository extends JpaRepository<Topic, Integer>{
	@Query("Select t from Topic t where t.subject.id = :subjectId")
	List<Topic> findBySubject(
			@Param("subjectId")Integer subjectId);

}
