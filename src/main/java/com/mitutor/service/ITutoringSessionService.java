package com.mitutor.service;

import java.util.List;

import com.mitutor.entities.TutoringSession;

public interface ITutoringSessionService extends CrudService<TutoringSession> {
	List<TutoringSession> findBySubjectName(String subjectName);

	public void deleteAll() throws Exception;
}
