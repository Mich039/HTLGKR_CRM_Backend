package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.Facility;

@Repository
public interface FacilityRepo extends JpaRepository<Facility, Long> {
	Facility findOne(Long id);
}
