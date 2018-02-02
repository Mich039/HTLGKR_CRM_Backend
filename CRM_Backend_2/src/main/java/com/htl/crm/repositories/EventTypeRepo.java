package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.EventType;

@Repository
public interface EventTypeRepo extends JpaRepository<EventType, Long> {
	EventType findOne(Long id);
}
