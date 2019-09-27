package com.mitutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitutor.entities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {

}
