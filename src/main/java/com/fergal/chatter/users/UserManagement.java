package com.fergal.chatter.users;

import org.springframework.stereotype.Service;

import com.fergal.chatter.domain.user.User;

@Service
public interface UserManagement {
	
	long createUser(String firstName, String lastName, String displayName);
	
	long updateUser(String firstName, String lastName, String displayName, long id);
	
	User getUser(long id);

}
