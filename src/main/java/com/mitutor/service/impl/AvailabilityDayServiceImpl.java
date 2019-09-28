package com.mitutor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitutor.entities.AvailabilityDay;
import com.mitutor.repository.IAvailabilityDayRepository;
import com.mitutor.service.IAvailabilityDayService;

@Service
public class AvailabilityDayServiceImpl implements IAvailabilityDayService {

	@Autowired
	private IAvailabilityDayRepository availabilityDayRepository;

	@Transactional(readOnly = true)
	@Override
	public Optional<AvailabilityDay> findById(Integer id) throws Exception {
		return availabilityDayRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<AvailabilityDay> findAll() throws Exception {
		return availabilityDayRepository.findAll();
	}

	@Transactional
	@Override
	public AvailabilityDay save(AvailabilityDay t) throws Exception {
		return availabilityDayRepository.save(t);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		availabilityDayRepository.deleteById(id);
	}

}
