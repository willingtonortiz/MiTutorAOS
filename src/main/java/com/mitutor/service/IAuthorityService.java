package com.mitutor.service;

import com.mitutor.entities.Authority;

public interface IAuthorityService extends CrudService<Authority> {
	public void deleteAll();
}
