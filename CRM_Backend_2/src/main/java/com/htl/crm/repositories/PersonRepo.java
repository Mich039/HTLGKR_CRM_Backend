package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
	Person findOne(Long id);
	
	Person findBy
}
