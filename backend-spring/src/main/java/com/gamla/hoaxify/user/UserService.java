package com.gamla.hoaxify.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	//constructor injection makes your class more easy to test
	UserRepository userRepository;

	BCryptPasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
}
