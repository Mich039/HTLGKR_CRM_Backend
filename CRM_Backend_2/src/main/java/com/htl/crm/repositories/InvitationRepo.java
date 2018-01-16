package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htl.crm.domain.Invitation;

public interface InvitationRepo extends JpaRepository<Invitation, Integer> {
	Invitation findOne(Integer id);
}
