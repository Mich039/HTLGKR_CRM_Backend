package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
	Address findOne(Long id);
	
}
