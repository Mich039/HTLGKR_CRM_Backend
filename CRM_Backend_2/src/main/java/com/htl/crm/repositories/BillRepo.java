package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<BillRepo, Integer> {
	BillRepo findOne(Integer id);
}
