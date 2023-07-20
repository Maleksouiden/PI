package com.example.mission.controllers;

import com.example.mission.entities.Publication;
import com.example.mission.services.PublicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
//publication
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class PublicationController {

    @Autowired
    private PublicationServices PS;

    @RequestMapping("/publications")
    public List<Publication> getAllPublications() {
        return PS.getAllPublications();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/publications")
    public void AddPublications(@RequestBody Publication publication) {
        PS.addNewPublication(publication);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "publications/{id}")
    public void updatePublications(@RequestBody Publication publication, @PathVariable int id) {
        PS.updatePublication(id, publication);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "publications/{id}")
    public void deletePublications(@PathVariable int id) {
        PS.deletePublication(id);
    }
}
