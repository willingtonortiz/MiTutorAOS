package com.mitutor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitutor.entities.Tutor;
import com.mitutor.repository.ITutorRepository;
import com.mitutor.service.ITutorService;

@Service
public class TutorServiceImpl implements ITutorService {

	@Autowired
	private ITutorRepository tutorRepository;

	@Transactional(readOnly = true)
	@Override
	public Optional<Tutor> findById(Integer id) throws Exception {

		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Tutor> findAll() throws Exception {

		return null;
	}

	@Transactional()
	@Override
	public Tutor save(Tutor t) throws Exception {

		return null;
	}

	@Transactional()
	@Override
	public void deleteById(Integer id) throws Exception {

	}

}