package com.fergal.chatter.domain.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserRepositoryService {
	
	private final UserRepository userRepository;

	public UserRepositoryService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public long createUser(User user) {
		
		user = userRepository.save(user);
		return user.getId();
	}
	
	public Optional<User> findUserById(long id) {
		return userRepository.findById(id);
	}
	
	public void deleteAll() {
		userRepository.deleteAll();
	}

}
