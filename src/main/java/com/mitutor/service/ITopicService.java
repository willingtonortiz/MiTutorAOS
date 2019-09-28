package com.mitutor.service;

import java.util.List;


import com.mitutor.entities.Topic;

public interface ITopicService extends CrudService<Topic> {
	List<Topic> findBySubject(Integer subjectId) throws Exception;



}
