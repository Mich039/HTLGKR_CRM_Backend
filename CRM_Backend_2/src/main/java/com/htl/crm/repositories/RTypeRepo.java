package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htl.crm.domain.RType;

public interface RTypeRepo extends JpaRepository<RType, Integer> {
	RType findOne(Integer id);
}
