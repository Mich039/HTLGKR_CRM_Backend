package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.Receiver;

@Repository
public interface ReveiverRepo extends JpaRepository<Receiver, Long> {
	Receiver findOne(Long id);
}
