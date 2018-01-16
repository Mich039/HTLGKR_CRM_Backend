package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htl.crm.domain.Receiver;

public interface ReveiverRepo extends JpaRepository<Receiver, Integer> {
	Receiver findOne(Integer id);
}
