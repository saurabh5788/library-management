package com.librarysystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarysystem.entities.User;
import com.librarysystem.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@Override
	public boolean isUserPresent(int userId){
		User user = userRepository.getById(userId);
		if(user == null)
			return false;
		return true;
	}
}
