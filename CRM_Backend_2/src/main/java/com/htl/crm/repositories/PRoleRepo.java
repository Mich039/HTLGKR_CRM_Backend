package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htl.crm.domain.PRole;

public interface PRoleRepo extends JpaRepository<PRole, Integer> {
	PRole findOne(Integer id);
}
