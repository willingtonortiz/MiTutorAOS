package com.mitutor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitutor.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	public Optional<User> findByUsername(String username);
}
