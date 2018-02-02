package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.AccessRight;

@Repository
public interface AccessRightRepo extends JpaRepository<AccessRight, Long>{
	AccessRight findOne(Long id);
	
}
