package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.PRole;

@Repository
public interface PRoleRepo extends JpaRepository<PRole, Long> {
	PRole findOne(Long id);
}
