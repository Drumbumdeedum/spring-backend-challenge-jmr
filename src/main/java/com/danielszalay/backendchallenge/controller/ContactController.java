package com.danielszalay.backendchallenge.controller;

import com.danielszalay.backendchallenge.model.Contact;
import com.danielszalay.backendchallenge.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(method=RequestMethod.GET, value="/contact")
    public Iterable<Contact> findContacts() {
        return contactService.findContacts();
    }

    @RequestMapping(method=RequestMethod.POST, value="/contact")
    public Contact saveContact(@RequestBody Contact contact) {
        contactService.saveContact(contact);
        return contact;
    }

    @RequestMapping(method=RequestMethod.GET, value="/contact/{id}")
    public Optional<Contact> findContactById(@PathVariable String id) {
        return contactService.findContactById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/contact/{id}")
    public Contact updateContact(@PathVariable String id, @RequestBody Contact contact) {
        return contactService.updateContact(id, contact);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/contact/{id}")
    public String deleteContact(@PathVariable String id) {
        contactService.deleteContact(id);
        return "";
    }
}
