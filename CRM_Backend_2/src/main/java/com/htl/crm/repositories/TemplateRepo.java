package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htl.crm.domain.Template;

public interface TemplateRepo extends JpaRepository<Template, Integer> {
	Template findOne(Integer id);
}
