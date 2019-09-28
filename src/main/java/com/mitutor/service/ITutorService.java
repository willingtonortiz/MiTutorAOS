package com.mitutor.service;

import com.mitutor.entities.Tutor;

public interface ITutorService extends CrudService<Tutor> {
	public void deleteAll();
}
