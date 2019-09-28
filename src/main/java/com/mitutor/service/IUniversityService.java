package com.mitutor.service;

import java.util.Optional;

import com.mitutor.entities.University;

public interface IUniversityService extends CrudService<University> {
	public Optional<University> findByName(String name);

	public void deleteAll();
}
