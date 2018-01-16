package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventInfo extends JpaRepository<EventInfo, Integer> {
	EventInfo findOne(Integer id);
}
