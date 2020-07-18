package com.fergal.chatter.domain.conversation;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ConversationRepository extends CrudRepository<Conversation, Long> {
	@Query(value="FROM Conversation c WHERE c.user1 = ?1 OR c.user2 = ?1 OR c.user3 = ?1 OR c.user4=?1 OR c.user5=?1 OR c.user6=?1 OR c.user7=?1 OR c.user8=?1 OR c.user9=?1 OR c.user10=?1")
	List<Conversation> findAllConversationsForUserId(long id);
}
