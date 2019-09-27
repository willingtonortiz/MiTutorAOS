package com.mitutor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitutor.entities.Availability;
import com.mitutor.repository.IAvailabilityDayRepository;
import com.mitutor.service.IAvailabilityService;

@Service
public class AvailabilityDayServiceImpl implements IAvailabilityService {

	@Autowired
	private IAvailabilityDayRepository availabilityDayRepository;

	@Transactional(readOnly = true)
	@Override
	public Optional<Availability> findById(Integer id) throws Exception {
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Availability> findAll() throws Exception {
		return null;
	}

	@Transactional
	@Override
	public Availability save(Availability t) throws Exception {
		return null;
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {

	}

}
