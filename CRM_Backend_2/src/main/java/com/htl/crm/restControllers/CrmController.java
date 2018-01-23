package com.htl.crm.restControllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.htl.crm.repositories.AccessRightRepo;

@RestController("/help/")
@EnableWebMvc
public class CrmController {
	
	@Autowired
	private AccessRightRepo accessRightRepo;

	@GetMapping(value = "/test/{id}", produces = "application/json")
	public String test(@PathVariable int id) throws IOException {
		
		return "Dicks"+id;

	}
	
}
