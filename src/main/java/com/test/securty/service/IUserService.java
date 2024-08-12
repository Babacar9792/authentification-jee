package com.test.securty.service;

import java.util.List;
import java.util.Optional;

import com.test.securty.dto.UserDto;

public interface IUserService {

	
	public List<UserDto> getAll();
	public boolean addUser(UserDto user);
	public Optional<UserDto> login(String email, String password);
}
