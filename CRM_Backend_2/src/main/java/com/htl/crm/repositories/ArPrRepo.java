package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArPrRepo extends JpaRepository<ArPrRepo, Integer> {
	ArPrRepo findOne(Integer id);
}
