package com.mitutor.service;

import java.util.Optional;

import com.mitutor.entities.Authority;

public interface IAuthorityService extends CrudService<Authority> {
	public Optional<Authority> findByAuthority(String authority) throws Exception;

	public void deleteAll();
}
