package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepo extends JpaRepository<FacilityRepo, Integer> {
	FacilityRepo findOne(Integer id);
}
