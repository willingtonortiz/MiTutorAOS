package com.mitutor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitutor.entities.TutoringSession;
import com.mitutor.repository.ITutoringSessionRepository;
import com.mitutor.service.ITutoringSessionService;

@Service
public class TutoringSessionServiceImpl implements ITutoringSessionService {

	@Autowired
	private ITutoringSessionRepository tutoringSessionRepository;

	@Transactional(readOnly = true)
	@Override
	public Optional<TutoringSession> findById(Integer id) throws Exception {

		return tutoringSessionRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<TutoringSession> findAll() throws Exception {

		return null;
	}

	@Transactional()
	@Override
	public TutoringSession save(TutoringSession t) throws Exception {

		return tutoringSessionRepository.save(t);
	}

	@Transactional()
	@Override
	public void deleteById(Integer id) throws Exception {

	}

}
