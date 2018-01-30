package com.htl.crm.restControllers;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.htl.crm.domain.AccessRight;
import com.htl.crm.domain.ArPr;
import com.htl.crm.domain.PData;
import com.htl.crm.domain.PDatatype;
import com.htl.crm.domain.Person;
import com.htl.crm.repositories.AccessRightRepo;
import com.htl.crm.repositories.PDatatypeRepo;
import com.htl.crm.repositories.PersonRepo;
import com.htl.crm.transferclasses.Contact;

@RestController("/help/")
@EnableWebMvc
public class CrmController {

	@Autowired
	private AccessRightRepo accessRightRepo;

	@GetMapping(value = "/test/{id}", produces = "application/json")
	public ResponseEntity<String> test(@PathVariable int id) throws IOException {

		AccessRight ar = accessRightRepo.findOne(id);
		// Wenn nicht gefunden ar == null
		List<ArPr> list = (List<ArPr>) ar.getArPrs();
		// Wenn kein Inhalt list.size() == 0
		ar.setAccessRight("fhadshfasdo");
		accessRightRepo.save(ar);
		return ResponseEntity.status(HttpStatus.OK).body("Test" + id);
	}

	@PostMapping(value = "/employee/addpersonaltutorial", produces = "application/json")
	public ResponseEntity<String> addPersonalTutorial(@RequestBody String string) {

		return ResponseEntity.status(HttpStatus.OK).body("Test" + string);
	}

	@Autowired
	private PersonRepo personRepo;
	@Autowired
	private PDatatypeRepo pdatatypeRepo;

	@PostMapping(value = "/login/logindata", produces = "application/json")
	public ResponseEntity<String> logindata(@RequestBody String password, String username) {

		List<Person> pl = personRepo.findAll();
		for (Person person : pl) {
			for (PData pdata : person.getPData()) {
				if (pdata.getPDatatype().getPDatatypeId() == pdatatypeRepo.findBy("password").getPDatatypeId()) {
					if (pdata.getValue().equals(password)) {
						if (pdata.getPDatatype().getPDatatypeId() == pdatatypeRepo.findBy("username")
								.getPDatatypeId()) {
							if (pdata.getValue().equals(username))
								return ResponseEntity.status(HttpStatus.OK).body(Long.toString(pdata.getPDataId()));
						}
					}
				}
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username or Password wrong");
			}
		}
		return null;

	};

	@GetMapping(value = "/getcontacts", produces = "application/json")
	public ResponseEntity<LinkedList<Contact>> kontakte() {
		LinkedList<Contact> contactList = new LinkedList<>();
		List<Person> pl = personRepo.findAll();
		for (Person person : pl) {
			if(person.getPDataFromType("persontype").getValue().equals("contact")) {
					Contact c = new Contact();
					c.setFirstname(person.getPDataFromType("firstname").getValue());
					c.setLastname(person.getPDataFromType("lastname").getValue());
					c.setPhonenumber(person.getPDataFromType("phonenumber").getValue());
					c.setEmail(person.getPDataFromType("e-mail").getValue());
					c.setAdresse(person.getPDataFromType("address").getValue());
					contactList.add(c);
				}
		}
		return ResponseEntity.status(HttpStatus.OK).body(contactList);
	}

}
