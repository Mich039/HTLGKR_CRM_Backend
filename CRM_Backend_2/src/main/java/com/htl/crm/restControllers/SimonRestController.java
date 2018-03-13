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
import com.htl.crm.repositories.AddressRepo;
import com.htl.crm.repositories.PersonRepo;
import com.htl.crm.transferclasses.Contact_company;
import com.htl.crm.transferclasses.Contact_person;
import com.htl.crm.transferclasses.Profile;
import com.htl.crm.transferclasses.TodoTrClass;

@RestController
@EnableWebMvc
public class SimonRestController {
	@Autowired
	private AccessRightRepo accessRightRepo;
	@Autowired
	private PersonRepo PersonRepo; // Normaler User
	@Autowired
	private AddressRepo addressRepo;

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
	public ResponseEntity<Profile> profile(@PathVariable int id) {
		Profile profile = new Profile();
		Person person = personRepo.findByid((long)id);
		if(person == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
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
		
		return ResponseEntity.status(HttpStatus.OK).body(profile);
	}

	/*@GetMapping(value = "/contact/{id}", produces = "application/json")
	public ResponseEntity<String> contact(@PathVariable int id) {
		Contact_person p_contact = new Contact_person();
		Contact_company c_contact = new Contact_company();
		List<Person> list = personRepo.findAll();
		Person person = personRepo.findOne((long)id);
		if(person == null) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such person/company found!");
		}
		if(person.getPDataFromType("personORcompany").getValue().equals("person")) 
		{
			p_contact.setSalutation(person.getPDataFromType("salutation").getValue());
			p_contact.setEmail(person.getPDataFromType("email").getValue());
			p_contact.setInterests(person.getPDataFromType("interests").getValue());
			p_contact.setPhonenumber(person.getPDataFromType("phonenumber").getValue());
				
				
			//get Address Information:
			List<Addresshistorie> addresshistories= person.getAddresshistories();
			Addresshistorie latestAddress = null;
			for(Addresshistorie addresshistory : addresshistories) {
				Address address = addresshistory.getAddress();
				if(latestAddress==null || address.getCreationDate().after(latestAddress.getAddress().getCreationDate()))
					latestAddress = addresshistory;
			}
			
			String streetnumber=null,postcode=null,town=null;
			p_contact.setStreet(latestAddress.getAddress().getStreetAddress());
			p_contact.setStreetnumber(streetnumber);
			p_contact.setPostcode(latestAddress.getAddress().getPostalcode());
			p_contact.setTown(town);
				
			return ResponseEntity.status(HttpStatus.OK).body(p_contact.toString());
		}
			
		if(person.getPDataFromType("personORcompany").getValue().equals("company")) {
				try {
					c_contact.setCompany_name(person.getPDataFromType("company_name").getValue());
					c_contact.setDescription(person.getPDataFromType("description").getValue());
					c_contact.setManagement(person.getPDataFromType("manager").getValue());
					c_contact.setDomain(person.getPDataFromType("domain").getValue());
					c_contact.setConnection(person.getPDataFromType("connection").getValue());
					
				}catch(NullPointerException ex) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Getting data for contact");
				}
					//Address:
					List<Addresshistorie> address = person.getAddresshistories();
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
				}
			
			}
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such person/company found!");
	}*/<
	
	//https://docs.google.com/document/d/14KWpFEtpOOrR0zdW04ybHCI8aZDmVP_ZK8W8jCoEd5U/edit#
}