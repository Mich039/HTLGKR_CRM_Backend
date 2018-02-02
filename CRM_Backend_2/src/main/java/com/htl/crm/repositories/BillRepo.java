package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.Bill;

@Repository
public interface BillRepo extends JpaRepository<Bill, Long> {
	Bill findOne(Long id);
}
