package com.mitutor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitutor.entities.Authority;
import com.mitutor.repository.IAuthorityRepository;
import com.mitutor.service.IAuthorityService;

@Service
public class AuthorityServiceImpl implements IAuthorityService {

	@Autowired
	private IAuthorityRepository authorityRepository;

	@Transactional(readOnly = true)
	@Override
	public Optional<Authority> findById(Integer id) throws Exception {
		return authorityRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Authority> findAll() throws Exception {
		return authorityRepository.findAll();
	}

	@Transactional()
	@Override
	public Authority save(Authority t) throws Exception {
		return authorityRepository.save(t);
	}

	@Transactional()
	@Override
	public void deleteById(Integer id) throws Exception {
		authorityRepository.deleteById(id);

	}

	@Transactional()
	@Override
	public void deleteAll() {
		authorityRepository.deleteAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Authority> findByAuthority(String authority) throws Exception {
		return authorityRepository.findByAuthority(authority);
	}

}
