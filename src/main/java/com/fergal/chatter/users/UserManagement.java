package com.fergal.chatter.users;

import org.springframework.stereotype.Service;

import com.fergal.chatter.domain.user.User;

import javassist.NotFoundException;

@Service
public interface UserManagement {
	
	long createUser(String firstName, String lastName, String displayName);
	
	User getUser(long id) throws NotFoundException;

}
