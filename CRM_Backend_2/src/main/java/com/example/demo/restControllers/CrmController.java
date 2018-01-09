package com.example.demo.restControllers;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController("/help/")
@EnableWebMvc
public class CrmController {

	@GetMapping(value = "/test/{id}", produces = "application/json")
	public String test(@PathVariable int id) throws IOException {
		
		return "Dicks"+id;

	}
	
}
