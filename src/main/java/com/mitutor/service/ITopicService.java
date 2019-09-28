package com.mitutor.service;

import com.mitutor.entities.Topic;

public interface ITopicService extends CrudService<Topic> {
	public void deleteAll() throws Exception;
}
