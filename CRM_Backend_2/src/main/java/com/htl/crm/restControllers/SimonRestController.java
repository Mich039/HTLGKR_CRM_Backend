package com.htl.crm.restControllers;

import static org.mockito.Matchers.booleanThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.htl.crm.domain.AccessRight;
import com.htl.crm.domain.Addresshistorie;
import com.htl.crm.domain.PData;
import com.htl.crm.domain.Person;
import com.htl.crm.domain.PersonTodo;
import com.htl.crm.domain.Todo;
import com.htl.crm.repositories.AccessRightRepo;
import com.htl.crm.repositories.PersonRepo;
import com.htl.crm.transferclasses.Contact_company;
import com.htl.crm.transferclasses.Contact_person;
import com.htl.crm.transferclasses.Profile;
import com.htl.crm.transferclasses.TodoTrClass;

@EnableWebMvc
public class SimonRestController {
	@Autowired
	private AccessRightRepo accessRightRepo;
	@Autowired
	private PersonRepo PersonRepo; //Normaler User

	//GET-Beispiel:
	@GetMapping(value = "/test/{id}", produces = "application/json")
	public ResponseEntity<String> test(@PathVariable int id) throws IOException {

		AccessRight ar = accessRightRepo.findOne((long)id);
		// Wenn nicht gefunden ar == null
		//List<ArPr> list = (List<ArPr>) ar.getArPrs();
		// Wenn kein Inhalt list.size() == 0
		ar.setAccessRight("fhadshfasdo");
		accessRightRepo.save(ar);
		return ResponseEntity.status(HttpStatus.OK).body("Test" + id);
	}
	
	
	@Autowired
	private PersonRepo personRepo;
	
	@GetMapping(value = "/profile/{id}", produces = "application/json")
	public ResponseEntity<String> profile(@PathVariable int id) {
		Profile profile = new Profile();
		Person person = personRepo.findOne((long)id);
		if(person == null)
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No person found!");
		profile.setFirstname(person.getPDataFromType("firstname").getValue());
		profile.setLastname(person.getPDataFromType("lastname").getValue());
		for( PersonTodo todo : person.getPersonTodos()) {
			profile.getTodolist().add(new TodoTrClass(
					todo.getTodo().getId(), 
					todo.getTodo().getCreationDatetime(), 
					todo.getTodo().getDone(), 
					todo.getTodo().getFinishedDatetime(),
					todo.getTodo().getText()));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(profile.toString());
	}
	
	/*@GetMapping(value = "/contact/{id}", produces = "application/json")
	public ResponseEntity<String> contact(@PathVariable int id) {
		Contact_person p_contact = new Contact_person();
		Contact_company c_contact = new Contact_company();
		List<Person> list = personRepo.findAll();
		for (Person poop : list) {
			if (poop!=null) {
				return poop.toString();
			}
		}
		for (Person person)
		for (Person per : list) {
			if(p.getPDataFromType("personORcompany").getValue().equals("person")
					&& per.getId() == Long.parseLong(Integer.toString(id))) {
				p_contact.setSalutation(per.getPDataFromType("salutation").getValue());
				p_contact.setEmail(p.getPDataFromType("email").getValue());
				p_contact.setInterests(p.getPDataFromType("interests").getValue());
				p_contact.setPhonenumber(p.getPDataFromType("phonenumber").getValue());
				//job_history: Link
				boolean t= p.equals("lol");
				
				//get Address Information:
				List<Addresshistorie> address = p.getAddresshistories();
				//int id = address.company_id();
				String street=null,streetnumber=null,postcode=null,town=null;
				p_contact.setStreet(street);
				p_contact.setStreetnumber(streetnumber);
				p_contact.setPostcode(postcode);
				p_contact.setTown(town);
				
				return ResponseEntity.status(HttpStatus.OK).body(p_contact.toString());
			}
			else if(p.getPDataFromType("personORcompany").getValue().equals("company")
					&& p.getId() == Long.parseLong(Integer.toString(id))) {
				if	(p.getPDataFromType("company_name").getValue()!=null){
				c_contact.setCompany_name(p.getPDataFromType("company_name").getValue());
				c_contact.setDescription(p.getPDataFromType("description").getValue());
				c_contact.setManagement(p.getPDataFromType("manager").getValue());
				c_contact.setDomain(p.getPDataFromType("domain").getValue());
				c_contact.setConnection(p.getPDataFromType("connection").getValue());
				
				//Address:
				List<Addresshistorie> address = p.getAddresshistories();
				String street=null,streetnumber=null,postcode=null,town=null;
				c_contact.setStreet(street);
				c_contact.setStreetnumber(streetnumber);
				c_contact.setPostcode(postcode);
				c_contact.setTown(town);
				
				//Lists:
				LinkedList<Contact_person> items = new LinkedList<>();
				for (Contact_person item : p.get?("contact_persons").getValue()) {
					items.add(item);
				}
				c_contact.setContact_persons(items);
				
				LinkedList<String> items = new LinkedList<>();
				for (String item : p.get?("contact_persons").getValue()) {
					items.add(item);
				}
				c_contact.setCompany_conversations(items);
				
				
				
				return ResponseEntity.status(HttpStatus.OK).body(c_contact.toString());
				}
			}
			
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such person/company found!");
	}*/
	
	//https://docs.google.com/document/d/14KWpFEtpOOrR0zdW04ybHCI8aZDmVP_ZK8W8jCoEd5U/edit#
}