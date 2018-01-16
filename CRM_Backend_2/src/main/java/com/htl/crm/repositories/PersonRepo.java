package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htl.crm.domain.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {
	Person findOne(Integer id);
}
