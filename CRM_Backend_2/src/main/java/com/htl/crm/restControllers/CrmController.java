package com.htl.crm.restControllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
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
import com.htl.crm.domain.Address;
import com.htl.crm.domain.ArPr;
import com.htl.crm.domain.PData;
import com.htl.crm.domain.PDatatype;
import com.htl.crm.domain.Person;
import com.htl.crm.repositories.AccessRightRepo;
import com.htl.crm.repositories.AddressRepo;
import com.htl.crm.repositories.ArPrRepo;
import com.htl.crm.repositories.PDataRepo;
import com.htl.crm.repositories.PDatatypeRepo;
import com.htl.crm.repositories.PersonRepo;
import com.htl.crm.transferclasses.AddressTO;
import com.htl.crm.transferclasses.Contact;
import com.htl.crm.transferclasses.ContactlistTO;
import com.htl.crm.transferclasses.PersonData;
import com.htl.crm.transferclasses.PostLogin;

@RestController("/help/")
@EnableWebMvc
public class CrmController {

	@Autowired
	private AccessRightRepo accessRightRepo;
	@Autowired
	private PersonRepo personRepo;
	@Autowired
	private PDatatypeRepo pdatatypeRepo;
	@Autowired
	private ArPrRepo arPrRepo;
	@Autowired
	private AddressRepo addressRepo;
 @Autowired PDataRepo pDataRepo;
	
	@GetMapping(value="/putPers" , produces="application/json")
	public ResponseEntity<AddressTO> putPers(){
		
		Address a = new Address();
		a.setCreationDate(new Date());
		a.setDoorNumber(new BigDecimal(12));
		a.setPostalcode(new BigDecimal(4672));
		a.setStreetAddress("Voitberg");
		a.setCity("Bachmanning");
		a.setCountry("Austria");
		
		Address newa = addressRepo.save(a);
		
		AddressTO ato = new AddressTO(newa.getId(),newa.getCity(),newa.getCreationDate(),newa.getDoorNumber(),newa.getStreetAddress());
		
		
		return ResponseEntity.status(HttpStatus.OK).body(ato);
	}
		
	
	@PostMapping(value = "/login/logindata", produces = "application/json")
	public ResponseEntity<String> logindata(@RequestBody PostLogin data) {
		
		List<Person> pl = personRepo.findAll();
		
		for (Person person : pl) {
			//person.getPDataFromType(data.getPassword());
			boolean passwordOK=false;
			boolean usernameOK=false;
			
			for (PData pdata : person.getPData()) {
				long pdataID=pdata.getPDatatype().getId();
				long pdataRepoPasswordID=pdatatypeRepo.findByType("password").getId();
				long pdataRepoUsernameID=pdatatypeRepo.findByType("username").getId();
				String pdataValue=pdata.getValue();
				
				/*if (pdataID==pdataRepoPasswordID) {
					if (pdata.getValue().equals(data.getPassword())) {
						if (pdata.getPDatatype().getId() == pdataRepoUsernameID) {
							if (pdataValue.equals(data.getUsername()))
								return ResponseEntity.status(HttpStatus.OK).body(Long.toString(pdata.getId()));
						}
					}
				}*/
				
				if (pdataID==pdataRepoPasswordID&&pdataValue.equals(data.getPassword())) {
					passwordOK=true;
				}
				
				if (pdataID==pdataRepoUsernameID&&pdataValue.equals(data.getUsername())) {
					usernameOK=true;
				}
				
				if(usernameOK&&passwordOK) {
					return ResponseEntity.status(HttpStatus.OK).body(Long.toString(pdata.getId()));
				}
				//return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			}
			}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	}
		

	

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
					ContactlistTO contactlistTO = new ContactlistTO();
					contactlistTO.setContactlist(contactList);
					
				}
		}
		return ResponseEntity.status(HttpStatus.OK).body(contactList);
	}

}
