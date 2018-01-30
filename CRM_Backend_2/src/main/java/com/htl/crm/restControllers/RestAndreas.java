package com.htl.crm.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.htl.crm.domain.Address;
import com.htl.crm.domain.PData;
import com.htl.crm.domain.PDatatype;
import com.htl.crm.domain.Person;
import com.htl.crm.repositories.AddressRepo;
import com.htl.crm.repositories.PDatatypeRepo;
import com.htl.crm.repositories.PersonRepo;
import com.htl.crm.transferclasses.AddContact;
import com.htl.crm.transferclasses.PersonData;

@RestController("/andi-stuff/")
@EnableWebMvc
public class RestAndreas {
	
	
		@Autowired
		PersonRepo Persons;
		@Autowired
		PDatatypeRepo PDataTypes;
		@Autowired
		AddressRepo Addresses;
		
		@PostMapping(value = "/addcontact", produces = "application/json")
		public ResponseEntity<String> addPersonalTutorial(@RequestBody AddContact contact) {
			Person p = new Person();
			for(PersonData persondata : contact.getPersonData()) {
				PData pdata = new PData();
				PDatatype pdatatype = PDataTypes.findBy(persondata.getDatatype());
				pdata.setPDatatype(pdatatype);
				pdata.setValue(persondata.getValue());
				p.addPData(pdata);
			}
			
			Persons.save(p);
			return ResponseEntity.status(HttpStatus.OK).body(
					p.getPDataFromType("salutation").getValue()+" "+
					p.getPDataFromType("firstname").getValue()+" "+
					p.getPDataFromType("lastname").getValue()+" wurde zur Datenbank hinzugefügt!");
		}
}
