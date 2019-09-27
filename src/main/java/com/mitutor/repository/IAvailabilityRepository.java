package com.mitutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitutor.entities.Availability;

@Repository
public interface IAvailabilityRepository extends JpaRepository<Availability, Integer> {

}
