package com.mitutor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitutor.entities.Subject;
import com.mitutor.repository.ISubjectRepository;
import com.mitutor.service.ISubjectService;

@Service
public class SubjectServiceImpl implements ISubjectService {

	@Autowired
	private ISubjectRepository subjectRepository;

	@Transactional(readOnly = true)
	@Override
	public Optional<Subject> findById(Integer id) throws Exception {

		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Subject> findAll() throws Exception {

		return null;
	}

	@Transactional()
	@Override
	public Subject save(Subject t) throws Exception {

		return null;
	}

	@Transactional()
	@Override
	public void deleteById(Integer id) throws Exception {

	}

}
