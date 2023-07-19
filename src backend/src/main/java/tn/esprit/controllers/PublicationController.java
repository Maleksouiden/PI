package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Commentaire;
import tn.esprit.entities.Publication;
import tn.esprit.services.CommentaireServices;
import tn.esprit.services.PublicationServices;

import java.util.List;

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
