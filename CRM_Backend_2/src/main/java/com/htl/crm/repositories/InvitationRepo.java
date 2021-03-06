package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.Invitation;

@Repository
public interface InvitationRepo extends JpaRepository<Invitation, Long> {
	Invitation findOne(Long id);
}
