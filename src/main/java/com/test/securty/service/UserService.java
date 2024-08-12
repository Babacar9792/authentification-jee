package com.test.securty.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.securty.dao.IUserDao;
import com.test.securty.dao.UserDao;
import com.test.securty.dto.UserDto;
import com.test.securty.entity.UserEntity;
import com.test.securty.mapper.UserMapper;

public class UserService implements IUserService {
	
	
	private IUserDao userDao = new UserDao();
	private UserMapper userMapper = new UserMapper();
	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Override
	public List<UserDto> getAll() {
		List<UserEntity> users = userDao.list(new UserEntity());
		return userMapper.listUserEntityToListUserDto(users);
	}
	
	@Override
	public boolean addUser(UserDto user) {
		boolean newUser =  userDao.save(userMapper.userDtoToUserEntity(user));
		if(newUser) {
			log.info("ajout du nouvelle utilisateur réussie");
		}
		else {
			log.warn("erreur lors de l'insertion du nouvelle utilisateur");
		}
		return newUser;
	}

	@Override
	public Optional<UserDto> login(String email, String password) {
		// TODO Auto-generated method stub
		Optional<UserEntity> userEntity = userDao.login(email, password);
		if(userEntity.isPresent()) {
			UserEntity user = userEntity.get();
			return Optional.of(userMapper.userEntityToUserDto(user));
		}
		return Optional.empty();
	}

}
