package com.fergal.chatter.domain.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class UserRepositoryServiceTests {
	
	@Autowired
	private UserRepositoryService userRepositoryService;
	
	@BeforeEach
	public void setup() {
		userRepositoryService.deleteAll();
	}
	
	@Test
	public void testCanCreateAndRetrieveUser() {

		User user = new User("Fergal", "McMahon","Fergalmcm");
		long id = userRepositoryService.createUser(user);
		
		User foundUser = userRepositoryService.findUserById(id).get();
		assertEquals(user.getFirstName(),foundUser.getFirstName());
	}

}
