package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.ArPr;

@Repository
public interface ArPrRepo extends JpaRepository<ArPr, Long> {
	ArPr findOne(Long id);
}
