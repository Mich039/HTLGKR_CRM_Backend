package com.htl.crm.restControllers;

import java.util.ArrayList;
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
import com.htl.crm.transferclasses.ConversationTO;
import com.htl.crm.transferclasses.PersonData;

@RestController
@EnableWebMvc
public class RestAndreas {

	@Autowired
	private PersonRepo persons;
	@Autowired
	private PDatatypeRepo PDataTypes;
	@Autowired
	private AddressRepo Addresses;
	@Autowired
	private PRoleRepo PRoles;
	@Autowired
	private EventRepo Events;
	@Autowired
	private EventTypeRepo eventTypes;
	@Autowired
	private PDataRepo pDataRepo;

	//TESTED!!
	@PostMapping(value = "/addcontact", produces = "application/json")
	public ResponseEntity<String> addPersonalTutorial(@RequestBody AddContact contact) throws Exception {
		Person p = new Person();
		PRole role = PRoles.findByRoleText(contact.getRole());
		if (role == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Specified Role does not exist!");

		}
		p.setPRole(role);
		Person person = persons.save(p);
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

		//Testing in progress by michi
	@GetMapping(value = "/getconversatoinsforcontact/{id}", produces = "application/json")
	public ResponseEntity<ArrayList<ConversationTO>> getConversationsOfContact(@PathVariable long id) {
		Person p = persons.findByid(id);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		ArrayList<Event> events = (ArrayList<Event>) Events.findByPerson(p);
		ArrayList<ConversationTO> convs = new ArrayList<>();
		for (Event event : events) {
			if(event.getEventType().getType().equals("company_conversation")) {
				ConversationTO conversationTO = new ConversationTO();
				if (!event.getEventpersons().isEmpty()) {
					conversationTO.setPerson_company(event.getEventpersons().get(0).getPerson().getPDataFromType("firstname").getValue());
				}
				conversationTO.setPerson_school(event.getPerson().getPDataFromType("firstname").getValue());
				if(event.getEventInfoByType("conversation_content") != null) {
					conversationTO.setConversation_content(event.getEventInfoByType("conversation_content").getValue());
				}
				if(event.getEventInfoByType("start_datetime") != null) {
				conversationTO.setTime_added(event.getEventInfoByType("start_datetime").getValue());
				}
				convs.add(conversationTO);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(convs);

	}

}
