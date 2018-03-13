package com.htl.crm.restControllers;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.htl.crm.domain.Event;
import com.htl.crm.domain.EventInfo;
import com.htl.crm.domain.PData;
import com.htl.crm.domain.PDatatype;
import com.htl.crm.domain.PRole;
import com.htl.crm.domain.Person;
import com.htl.crm.repositories.AddressRepo;
import com.htl.crm.repositories.EventRepo;
import com.htl.crm.repositories.EventTypeRepo;
import com.htl.crm.repositories.PDataRepo;
import com.htl.crm.repositories.PDatatypeRepo;
import com.htl.crm.repositories.PRoleRepo;
import com.htl.crm.repositories.PersonRepo;
import com.htl.crm.transferclasses.AddContact;
import com.htl.crm.transferclasses.Conversation;
import com.htl.crm.transferclasses.PersonData;

@EnableWebMvc
public class RestAndreas {

	
		
		
	@Autowired
	private PersonRepo Persons;
	@Autowired
	private	PDatatypeRepo PDataTypes;
	@Autowired
	private	AddressRepo Addresses;
	@Autowired
	private	PRoleRepo PRoles;
	@Autowired
	private	EventRepo Events;
	@Autowired
	private	EventTypeRepo EventTypes;
	@Autowired
	private	PDataRepo pDataRepo;

	@Transactional
	@PostMapping(value = "/addcontact", produces = "application/json")
	public ResponseEntity<String> addPersonalTutorial(@RequestBody AddContact contact) {
		Person p = new Person();
		PRole role = PRoles.findByRoleText(contact.getRole());
		if (role == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Specified Role does not exist!");

		}
		p.setPRole(role);
		Person person = Persons.save(p);
		for (PersonData persondata : contact.getPersonData()) {
			PData pdata = new PData();
			PDatatype pdatatype = PDataTypes.findByType(persondata.getDatatype());
			if (pdatatype == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Specified PDataType does not exist!");
			}
			pdata.setPDatatype(pdatatype);
			pdata.setPerson(person);
			pdata.setValue(persondata.getValue());
			p.addPData(pDataRepo.save(pdata));
			p.addPData(pdata);
		}
			
		
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
		
//	@PostMapping(value = "/addcontact", produces = "application/json")
//	public ResponseEntity<String> addPersonalTutorial(@RequestBody AddContact contact) {
//		Person p = new Person();
//		for(PersonData persondata : contact.getPersonData()) {
//			PData pdata = new PData();
//			PDatatype pdatatype = PDataTypes.findByType(persondata.getDatatype());
//			pdata.setPDatatype(pdatatype);
//			pdata.setValue(persondata.getValue());
//			p.addPData(pdata);
//		}
//		
//		Persons.save(p);
//		return ResponseEntity.status(HttpStatus.OK).body(
//				p.getPDataFromType("salutation").getValue()+" "+
//				p.getPDataFromType("firstname").getValue()+" "+
//				p.getPDataFromType("lastname").getValue()+" wurde zur Datenbank hinzugefügt!");
//

		@GetMapping(value="/getconversatoinsofcompany", produces = "application/json")
		public ResponseEntity<LinkedList<Conversation>> getConversationsOfCompany(@PathVariable long id){
			Person p = Persons.findOne(id);
			
			LinkedList<Event> events = (LinkedList<Event>) Events.findByPerson(p);
			LinkedList<Conversation> convs = new LinkedList<>();
			for(Event e : events) {
				if(e.getEventType().getEventTypeId() == EventTypes.findByType("company_conversation").getEventTypeId())
					convs.add(new Conversation(e.getEventInfoByType("start_datetime").getValue(),
								e.getEventInfoByType("company_person").getValue(),
								e.getPerson().getPDataFromType("first_name")+" "+e.getPerson().getPDataFromType("last_name") , 
								e.getEventInfoByType("conversatoin_content").getValue()
								)
							);
			}
			return ResponseEntity.status(HttpStatus.OK).body(convs);
			
		}


	}
