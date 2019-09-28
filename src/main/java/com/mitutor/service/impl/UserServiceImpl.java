package com.mitutor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitutor.entities.User;
import com.mitutor.repository.IUserRepository;
import com.mitutor.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Transactional(readOnly = true)
	@Override
	public Optional<User> findById(Integer id) throws Exception {
		return userRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> findAll() throws Exception {
		return userRepository.findAll();
	}

	@Transactional()
	@Override
	public User save(User user) throws Exception {
		return userRepository.save(user);
	}

	@Transactional()
	@Override
	public void deleteById(Integer id) throws Exception {
		userRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

}
