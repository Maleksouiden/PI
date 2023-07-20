package com.example.mission.services;


import com.example.mission.DAO.ContactRepository;
import com.example.mission.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServices {

    @Autowired
    ContactRepository CRepo ;

    public List<Contact> getAllContacts(){
        List<Contact> contacts = new ArrayList<>() ;
        CRepo.findAll().forEach(contacts::add);
        return contacts ;
    }

    public String addNewContact(Contact contact){
        CRepo.save(contact) ;
        return "contact ajouter" ;
    }

    public String updateContact(int id, Contact contact) {
        CRepo.save(contact) ;
        return "contact Modifier" ;
    }


    public String deleteContact(int id){
        CRepo.deleteById(id);
        return "contact Supprimer" ;
    }
}
