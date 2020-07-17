package com.fergal.chatter.domain.outbox;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface OutboxItemRepository extends CrudRepository<OutboxItem,Long>{
	
	List<OutboxItem> findAllByRecipientId(long id);

}
