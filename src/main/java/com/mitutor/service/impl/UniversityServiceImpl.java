package com.mitutor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitutor.entities.University;
import com.mitutor.repository.IUniversityRepository;
import com.mitutor.service.IUniversityService;

@Service
public class UniversityServiceImpl implements IUniversityService {

	@Autowired
	private IUniversityRepository universityRepository;

	@Transactional(readOnly = true)
	@Override
	public Optional<University> findById(Integer id) throws Exception {
		return universityRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<University> findAll() throws Exception {
		return universityRepository.findAll();
	}

	@Transactional()
	@Override
	public University save(University t) throws Exception {
		return universityRepository.save(t);
	}

	@Transactional()
	@Override
	public void deleteById(Integer id) throws Exception {
		universityRepository.deleteById(id);
	}

	@Override
	public Optional<University> findByName(String name) {
		return universityRepository.findByName(name);
	}

	@Override
	public void deleteAll() {
		universityRepository.deleteAll();
	}

}
