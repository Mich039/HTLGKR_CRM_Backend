package com.htl.crm.repositories;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.PData;

@Repository
public interface PDataRepo extends JpaRepository<PData, Long> {
	PData findOne(Long id);
	
	@NamedQuery("select pd from PData pd where pd.");
	
	
}
