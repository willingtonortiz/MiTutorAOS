package com.mitutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitutor.entities.AvailabilityDay;

@Repository
public interface IAvailabilityDayRepository extends JpaRepository<AvailabilityDay, Integer>{

}
