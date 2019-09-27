package com.mitutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitutor.entities.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
