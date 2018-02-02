package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.RType;

@Repository
public interface RTypeRepo extends JpaRepository<RType, Long> {
	RType findOne(Long id);
}
