package com.mitutor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitutor.entities.Qualification;
import com.mitutor.service.IQualificationService;

@Service
public class QualificationServiceImpl implements IQualificationService {

	@Autowired
	private IQualificationService qualificationService;

	@Transactional(readOnly = true)
	@Override
	public Optional<Qualification> findById(Integer id) throws Exception {

		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Qualification> findAll() throws Exception {

		return null;
	}

	@Transactional()
	@Override
	public Qualification save(Qualification t) throws Exception {

		return null;
	}

	@Transactional()
	@Override
	public void deleteById(Integer id) throws Exception {

	}

}
