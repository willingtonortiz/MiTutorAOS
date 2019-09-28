package com.mitutor.service;

import com.mitutor.entities.User;

public interface IUserService extends CrudService<User> {
	public void deleteAll();
}
