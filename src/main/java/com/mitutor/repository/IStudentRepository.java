package com.mitutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitutor.entities.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer>{

}
