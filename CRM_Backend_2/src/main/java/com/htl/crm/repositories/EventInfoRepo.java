package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.EventInfo;

@Repository
public interface EventInfoRepo extends JpaRepository<EventInfo, Long> {
	EventInfo findOne(Long id);
}
