package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.PDatatype;

@Repository
public interface PDatatypeRepo extends JpaRepository<PDatatype, Long> {
	PDatatype findOne(Long id);
	PDatatype findByType(String type);
}
