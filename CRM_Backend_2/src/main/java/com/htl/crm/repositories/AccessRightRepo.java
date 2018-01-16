package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htl.crm.domain.AccessRight;

public interface AccessRightRepo extends JpaRepository<AccessRight, Integer>{
	AccessRight findOne(Integer id);
	
}
