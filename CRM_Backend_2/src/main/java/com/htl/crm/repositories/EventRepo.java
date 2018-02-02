package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.Event;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {
	Event findOne(Long id);
}
