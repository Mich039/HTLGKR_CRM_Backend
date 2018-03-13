package com.htl.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htl.crm.domain.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
	Person findOne(Long id);
//	"Select person.id from PRE_5M.PERSON person \r\n" + 
//	"Join PRE_5M.P_DATA pdatapassword ON pdatapassword.PERSON_FK = person.ID \r\n" + 
//	"JOIN PRE_5M.P_DATATYPE pdatatypepassword On pdatapassword.P_DATATYPE_FK = pdatatypepassword.ID\r\n" + 
//	"Join PRE_5M.P_DATA pdatausername ON pdatausername.PERSON_FK = person.ID\r\n" + 
//	"JOIN PRE_5M.P_DATATYPE pdatatypeusername On pdatausername.P_DATATYPE_FK = pdatatypeusername.ID\r\n" + 
//	"where pdatatypepassword.TYPE = 'password' or pdatatypeusername.TYPE = 'username'"
	
}
