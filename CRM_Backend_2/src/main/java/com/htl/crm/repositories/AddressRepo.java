package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<AddressRepo, Integer> {
	AddressRepo findOne(Integer id);
}
