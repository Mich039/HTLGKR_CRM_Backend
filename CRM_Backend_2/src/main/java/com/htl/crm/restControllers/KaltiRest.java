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

@RestController("/kaltusmaltusmaximus/")
@EnableWebMvc
public class KaltiRest {

	@Autowired
	PersonRepo Persons;
	
	@GetMapping(value = "/test/{id}", produces = "application/json")
	public ResponseEntity<String> GetPerson(@PathVariable int id){
		
	/*	Person p = Persons.findOne(id);
		
		long personId = p.getId();
		List<Addresshistorie> addresshistories = (List)p.getAddresshistories();
		List<Event> events = (List)p.getEvents();
		List<PRole> prole = (List)p.getPRole();
		List<Relation> relation = (List)p.getRelation();
		List<PData> pdata = (List)p.getPData();
		List<Receiver> receivers = (List)p.getReceivers();
		List<Relation> relations = (List)p.getRelation();
		List<Template> templates = (List)p.getTemplates();

		
		PersonObject po = new PersonObject();
		po.setPersonId(personId);
		po.setAddresshistories(addresshistories);
		po.setEvents(events);
		po.setPRole(prole);
		po.setRole(relation);
		po.setPData(pdata);
		po.setReceivers(receivers);
		po.setR(relations);
		po.setTemplates(templates);
		*/
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
