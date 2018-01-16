package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepo extends JpaRepository<EventTypeRepo, Integer> {
	EventTypeRepo findOne(Integer id);
}
