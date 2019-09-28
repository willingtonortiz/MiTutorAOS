package com.mitutor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitutor.entities.Student;
import com.mitutor.repository.IStudentRepository;
import com.mitutor.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepository studentRepository;

	@Transactional(readOnly = true)
	@Override
	public Optional<Student> findById(Integer id) throws Exception {

		return studentRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Student> findAll() throws Exception {

		return null;
	}

	@Transactional()
	@Override
	public Student save(Student t) throws Exception {

		return null;
	}

	@Transactional()
	@Override
	public void deleteById(Integer id) throws Exception {

	}

}
