package com.eazybytes.eazybankrestapi.repository;

import com.eazybytes.eazybankrestapi.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	
}
