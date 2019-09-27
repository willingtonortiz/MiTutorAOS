package com.mitutor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitutor.entities.Topic;
import com.mitutor.repository.ITopicRepository;
import com.mitutor.service.ITopicService;

@Service
public class TopicServiceImpl implements ITopicService {

	@Autowired
	private ITopicRepository topicRepository;

	@Transactional(readOnly = true)
	@Override
	public Optional<Topic> findById(Integer id) throws Exception {

		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Topic> findAll() throws Exception {

		return null;
	}

	@Transactional()
	@Override
	public Topic save(Topic t) throws Exception {

		return null;
	}

	@Transactional()
	@Override
	public void deleteById(Integer id) throws Exception {

	}

}