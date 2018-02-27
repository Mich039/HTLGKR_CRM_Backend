package com.htl.crm.restControllers;

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
import com.htl.crm.domain.PData;
import com.htl.crm.domain.Person;
import com.htl.crm.repositories.AccessRightRepo;
import com.htl.crm.repositories.PersonRepo;
import com.htl.crm.transferclasses.Profile;

@EnableWebMvc
public class SimonRestController {
	@Autowired
	private AccessRightRepo accessRightRepo;
	@Autowired
	private PersonRepo Person; //Normaler User

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
	
	//GET: Profil
	@GetMapping(value = "/profile/data/{Person_ID}", produces = "application/json")
	public ResponseEntity<String> profiledata(@PathVariable int Person_id) throws IOException {
				Person ar = Person.findOne((long)Person_id);
				 List<PData> data = ar.getPData();
				
				PData pdata = null;
				int ID = (int) pdata.getId(); //value suchen
				
				// Wenn nicht gefunden ar == null
				List<PData> list = (List<PData>) ar.getPData(); //Objekt
				ar.getPData().toArray();
				//int P_ID = ar[2];
				//List<PData> list2 = (List<PData>) ar.getPRole();
				
				// Wenn kein Inhalt list.size() == 0
				if (list.size()==0) {
					return null;
				}
		return ResponseEntity.status(HttpStatus.OK).body("Test" + Person_id);
	}
	
	@Autowired
	private PersonRepo personRepo;
	
	@GetMapping(value = "/profile/{id}", produces = "application/json")
	public ResponseEntity<String> profile(@PathVariable int id) {
		Profile profile = new Profile();

		List<Person> pl = personRepo.findAll();
		for (Person person : pl) {
			if (person.getPDataFromType("persontype").getValue().equals("user")
					&& person.getId() == Long.parseLong(Integer.toString(id))) {
				profile.setFirstname(person.getPDataFromType("firstname").getValue());
				profile.setLastname(person.getPDataFromType("lastname").getValue());
				LinkedList<String> items = new LinkedList<>();
				for (String item : person.getPDataFromType("todolist").getValue().split(",")) {
					items.add(item);
				}
				profile.setTodolist(items);
				return ResponseEntity.status(HttpStatus.OK).body(profile.toString());
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No person found!");
	}
}