package com.mitutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitutor.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
}
