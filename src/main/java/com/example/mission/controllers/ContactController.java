package com.example.mission.controllers;

import com.example.mission.entities.Contact;
import com.example.mission.services.ContactServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ContactController {

    @Autowired
    private ContactServices ContactSer;

    @RequestMapping("/contacts")
    public List<Contact> getAllContacts() {
        return ContactSer.getAllContacts() ;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/contacts")
    public void AddContacts(@RequestBody Contact contact) {
        ContactSer.addNewContact(contact);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "contacts/{id}")
    public void updateContacts(@RequestBody Contact contact, @PathVariable int id) {
        ContactSer.updateContact(id, contact);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "contacts/{id}")
    public void deleteContacts(@PathVariable int id) {
        ContactSer.deleteContact(id);
    }
}
