package com.fergal.chatter.domain.conversation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ConversationRepository extends CrudRepository<Conversation, Long> {
}
