package com.danielszalay.backendchallenge.repository;

import com.danielszalay.backendchallenge.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, String> {

}
