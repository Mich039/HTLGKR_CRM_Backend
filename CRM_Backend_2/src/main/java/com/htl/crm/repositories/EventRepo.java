package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<EventRepo, Integer> {
	EventRepo findOne(Integer id);
}
