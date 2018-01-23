package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htl.crm.domain.PDatatype;

public interface PDatatypeRepo extends JpaRepository<PDatatype, Integer> {
	PDatatype findOne(Integer id);
	PDatatype findBy(String type);
}
