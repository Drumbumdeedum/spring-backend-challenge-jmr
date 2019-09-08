package com.danielszalay.backendchallenge.service;

import com.danielszalay.backendchallenge.model.Contact;
import com.danielszalay.backendchallenge.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public Iterable<Contact> findContacts() {
        return contactRepository.findAll();
    }

    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    public Optional<Contact> findContactById(String id) {
        return contactRepository.findById(id);
    }


    public Contact updateContact(String id, Contact contact) {
        Optional<Contact> foundContact = contactRepository.findById(id);
        Contact c = foundContact.get();
        if(contact.getName() != null)
            c.setName(contact.getName());
        if(contact.getPhoneNumber() != null)
            c.setPhoneNumber(contact.getPhoneNumber());
        if(contact.getEmailAddress() != null)
            c.setEmailAddress(contact.getEmailAddress());
        contactRepository.save(c);
        return c;
    }

    public void deleteContact(String id) {
        Optional<Contact> foundContact = contactRepository.findById(id);
        Contact contact = foundContact.get();
        contactRepository.delete(contact);
    }
}
