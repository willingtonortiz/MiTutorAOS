package com.mitutor.service;

import java.util.List;

import com.mitutor.entities.Tutor;

public interface ITutorService extends CrudService<Tutor> {
	public void deleteAll() throws Exception;

	public List<Tutor> findBySubjectName(String subjectName) throws Exception;
}
