package com.fergal.chatter.domain.conversation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conversation {

	private static final long EMPTY_LONG = -1;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String conversationName;
	
	private long user1;
	
	private long user2;
	
	private long user3;
	
	private long user4;
	
	private long user5;
	
	private long user6;
	
	private long user7;
	
	private long user8;
	
	private long user9;
	
	private long user10;
	
	public Conversation() {}
	

	public Conversation(String conversationName, Set<Long> members) {
		super();
		this.conversationName = conversationName;

		setAllUsers(members);
	}

	public String getConversationName() {
		return conversationName;
	}

	public void setConversationName(String conversationName) {
		this.conversationName = conversationName;
	}

	public long getId() {
		return id;
	}

	public long getUser1() {
		return user1;
	}

	public void setUser1(long user1) {
		this.user1 = user1;
	}

	public long getUser2() {
		return user2;
	}

	public void setUser2(long user2) {
		this.user2 = user2;
	}

	public long getUser3() {
		return user3;
	}

	public void setUser3(long user3) {
		this.user3 = user3;
	}

	public long getUser4() {
		return user4;
	}

	public void setUser4(long user4) {
		this.user4 = user4;
	}

	public long getUser5() {
		return user5;
	}

	public void setUser5(long user5) {
		this.user5 = user5;
	}

	public long getUser6() {
		return user6;
	}

	public void setUser6(long user6) {
		this.user6 = user6;
	}

	public long getUser7() {
		return user7;
	}

	public void setUser7(long user7) {
		this.user7 = user7;
	}

	public long getUser8() {
		return user8;
	}

	public void setUser8(long user8) {
		this.user8 = user8;
	}

	public long getUser9() {
		return user9;
	}

	public void setUser9(long user9) {
		this.user9 = user9;
	}

	public long getUser10() {
		return user10;
	}

	public void setUser10(long user10) {
		this.user10 = user10;
	}
	
	public List<Long> getAllUsers(){
		
		List<Long> allUsers = Arrays.asList(user1,user2,user3,user4,user5,
				user6,user7,user8,user9,user10);
		
		List<Long> trimmedUsers = new ArrayList<>();
		
		for(long user : allUsers) {
			if(user!=EMPTY_LONG) {
				trimmedUsers.add(user);
			}
		}
		
		return trimmedUsers;
	}
	
	public void setAllUsers(Set<Long> members) {
		List<Long> membersArray = new ArrayList<>();
		membersArray.addAll(members);
		
		if(membersArray.size()<10) {
			for(int i =membersArray.size()-1; i<10; i++) {
				membersArray.add(EMPTY_LONG);
			}
		}
		
		user1 = membersArray.get(0);
		user2 = membersArray.get(1);
		user3 = membersArray.get(2);
		user4 = membersArray.get(3);
		user5 = membersArray.get(4);
		user6 = membersArray.get(5);
		user7 = membersArray.get(6);
		user8 = membersArray.get(7);
		user9 = membersArray.get(8);
		user10 = membersArray.get(9);
	}
	
	
	
	
	
	
	
	
}
