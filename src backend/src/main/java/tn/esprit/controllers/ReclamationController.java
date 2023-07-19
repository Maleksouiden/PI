package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Reclamation;
import tn.esprit.services.ReclamationServices;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ReclamationController {

    @Autowired
    private ReclamationServices RS ;

    // Read all reclamations
    @RequestMapping("/reclamations")
    public List<Reclamation> getAllReclamation(){
        return RS.getAllReclamations() ;
    }

    // add new reclamation
    @RequestMapping(method = RequestMethod.POST, value = "/reclamations/add")
    public void AddReclamation(@RequestBody Reclamation newReclamation){
        RS.addNewReclamation(newReclamation);
    }


    // Update reclamation
    @RequestMapping(method = RequestMethod.PUT, value = "reclamations/{id}")
    public void updateReclamation(@RequestBody Reclamation reclamationUpdated, @PathVariable int id){
        RS.updateReclamation(id, reclamationUpdated) ;
    }

    // delete reclamation
    @RequestMapping(method = RequestMethod.DELETE, value = "reclamations/{id}")
    public void deleteReclamation(@PathVariable int id){
        RS.deleteReclamation(id);
    }
}
