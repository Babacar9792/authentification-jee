package com.test.securty.mapper;

import java.util.stream.Collectors;
import java.util.List;
import com.test.securty.dto.UserDto;
import com.test.securty.entity.UserEntity;

public class UserMapper {
	
	
	
	public UserDto userEntityToUserDto(UserEntity user){
		return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
	}
	
	public UserEntity userDtoToUserEntity(UserDto user){
		return new UserEntity(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
	}
	
	public List<UserDto> listUserEntityToListUserDto(List<UserEntity> users){
		return users
				.stream()
				.map(this::userEntityToUserDto
				).collect(Collectors.toList());
	}

}
