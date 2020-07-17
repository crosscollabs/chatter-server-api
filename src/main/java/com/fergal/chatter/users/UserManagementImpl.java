package com.fergal.chatter.users;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fergal.chatter.domain.user.User;
import com.fergal.chatter.domain.user.UserRepositoryService;

@Service
public class UserManagementImpl implements UserManagement{
	
	private final UserRepositoryService userRepositoryService;
	
	public UserManagementImpl(UserRepositoryService userRepositoryService) {
		this.userRepositoryService = userRepositoryService;
	}
	

	@Override
	public long createUser(String firstName, String lastName, String displayName) {

		return userRepositoryService.createUser(new User(firstName, lastName, displayName));
	}

	@Override
	public long updateUser(String firstName, String lastName, String displayName, long id) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public User getUser(long id) {
		Optional<User> user =
		userRepositoryService.findUserById(id);
		System.out.println("Performed search for user "+id);
		return user.get();
	}

}
