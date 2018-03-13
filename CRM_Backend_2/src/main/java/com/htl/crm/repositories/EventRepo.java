package com.htl.crm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.Event;
import com.htl.crm.domain.Person;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {
	Event findOne(Long id);
	List<Event> findByPerson(Person p);
}
