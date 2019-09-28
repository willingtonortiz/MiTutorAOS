package com.mitutor.service;

import com.mitutor.entities.Subject;

public interface ISubjectService extends CrudService<Subject> {
	public void deleteAll() throws Exception;

}
