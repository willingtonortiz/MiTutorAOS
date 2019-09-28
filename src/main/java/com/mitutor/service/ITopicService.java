package com.mitutor.service;

import java.util.List;


import com.mitutor.entities.Topic;

public interface ITopicService extends CrudService<Topic> {
	public void deleteAll() throws Exception;
	List<Topic> findBySubject(Integer subjectId) throws Exception;



}
