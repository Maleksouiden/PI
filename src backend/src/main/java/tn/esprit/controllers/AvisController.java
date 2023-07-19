package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Avis;
import tn.esprit.services.AvisServices;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class AvisController {

    @Autowired
    private AvisServices AvS  ;

    @RequestMapping("/avis")
    public List<Avis> getAllAvis(){
        return AvS.getAllAvis() ;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/avis")
    public void AddAvis(@RequestBody Avis avis){
        AvS.addNewAvis(avis);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "avis/{id}")
    public void updateAvis(@RequestBody Avis avis, @PathVariable int id){
        AvS.updateAvis(id, avis) ;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "avis/{id}")
    public void deleteAvis(@PathVariable int id){ AvS.deleteAvis(id);
    }
}
