package com.librarysystem.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarysystem.entities.User;
import com.librarysystem.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserServiceImpl.class);
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@Override
	public boolean isUserPresent(int userId){
		Optional<User> user = userRepository.findById(userId);
		LOGGER.info("User Found {} : ",user);
		return user.isPresent();
	}
}
