package com.mitutor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitutor.entities.Person;
import com.mitutor.repository.IPersonRepository;
import com.mitutor.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private IPersonRepository personRepository;

	@Transactional(readOnly = true)
	@Override
	public Optional<Person> findById(Integer id) throws Exception {
		return personRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Person> findAll() throws Exception {
		return personRepository.findAll();
	}

	@Transactional()
	@Override
	public Person save(Person t) throws Exception {

		return personRepository.save(t);
	}

	@Transactional()
	@Override
	public void deleteById(Integer id) throws Exception {
		personRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		personRepository.deleteAll();
	}

}
