package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htl.crm.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{
	Role findOne(Integer id);

}
