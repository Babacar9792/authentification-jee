package com.test.securty.dao;

import java.util.Optional;

import com.test.securty.entity.UserEntity;

public interface IUserDao extends IRepository<UserEntity> {
	
	public Optional<UserEntity> login(String email, String password);

}
