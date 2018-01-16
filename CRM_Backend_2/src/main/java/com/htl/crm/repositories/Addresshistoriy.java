package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htl.crm.domain.Addresshistorie;

public interface Addresshistoriy extends JpaRepository<Addresshistorie, Integer> {
	Addresshistorie findOne(Integer id);
}
