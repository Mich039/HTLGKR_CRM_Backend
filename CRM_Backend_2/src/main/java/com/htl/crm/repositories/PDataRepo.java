package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htl.crm.domain.PData;

public interface PDataRepo extends JpaRepository<PData, Integer> {
	PData findOne(Integer id);
}
