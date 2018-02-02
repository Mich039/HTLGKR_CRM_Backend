package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.Template;

@Repository
public interface TemplateRepo extends JpaRepository<Template, Long> {
	Template findOne(Long id);
}
