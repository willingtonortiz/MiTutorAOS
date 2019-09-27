package com.mitutor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitutor.entities.Role;
import com.mitutor.repository.IRoleRepository;
import com.mitutor.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleRepository roleRepository;

	@Transactional(readOnly = true)
	@Override
	public Optional<Role> findById(Integer id) throws Exception {
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Role> findAll() throws Exception {
		return null;
	}

	@Transactional()
	@Override
	public Role save(Role t) throws Exception {
		return null;
	}

	@Transactional()
	@Override
	public void deleteById(Integer id) throws Exception {

	}

}
