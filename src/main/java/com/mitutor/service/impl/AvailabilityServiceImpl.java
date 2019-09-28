package com.mitutor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitutor.entities.Availability;
import com.mitutor.repository.IAvailabilityRepository;
import com.mitutor.service.IAvailabilityService;

@Service
public class AvailabilityServiceImpl implements IAvailabilityService {

	@Autowired
	private IAvailabilityRepository availabilityRepository;

	@Transactional(readOnly = true)
	@Override
	public Optional<Availability> findById(Integer id) throws Exception {
		return availabilityRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Availability> findAll() throws Exception {
		return availabilityRepository.findAll();
	}

	@Transactional()
	@Override
	public Availability save(Availability t) throws Exception {
		return availabilityRepository.save(t);
	}

	@Transactional()
	@Override
	public void deleteById(Integer id) throws Exception {
		availabilityRepository.deleteById(id);
	}

}
