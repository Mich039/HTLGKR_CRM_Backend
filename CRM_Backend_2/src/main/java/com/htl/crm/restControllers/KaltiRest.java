package com.htl.crm.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.htl.crm.domain.Addresshistorie;
import com.htl.crm.domain.Event;
import com.htl.crm.domain.PData;
import com.htl.crm.domain.PRole;
import com.htl.crm.domain.Person;
import com.htl.crm.domain.Receiver;
import com.htl.crm.domain.Relation;
import com.htl.crm.domain.Template;
import com.htl.crm.repositories.PersonRepo;
import com.htl.crm.transferclasses.PersonTO;

@RestController
@EnableWebMvc
public class KaltiRest {

	@Autowired
	PersonRepo Persons;
	
	@GetMapping(value = "/person/getPersonData/{id}", produces = "application/json")
	public ResponseEntity<PersonTO> GetPerson(@PathVariable int id){
		Person person = Persons.findOne(new Long(id));
		if (person == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		PersonTO personTO = new PersonTO(person);
		
		return ResponseEntity.status(HttpStatus.OK).body(personTO);
	}
}
