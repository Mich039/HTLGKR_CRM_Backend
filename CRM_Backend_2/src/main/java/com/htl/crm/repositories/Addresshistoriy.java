package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.Addresshistorie;
@Repository
public interface Addresshistoriy extends JpaRepository<Addresshistorie, Long> {
	Addresshistorie findOne(Long id);
}
