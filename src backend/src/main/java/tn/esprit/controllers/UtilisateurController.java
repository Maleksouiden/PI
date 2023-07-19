package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Utilisateur;
import tn.esprit.services.UtilisateurServices;

import java.util.List;

@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurServices Us  ;

    @RequestMapping("/utilisateurs")
    public List<Utilisateur> getAllUtilisateurs(){
        return Us.getAllUtilisateurs() ;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/utilisateurs/connect")
    public ResponseEntity<String> getConnectedUser(@RequestBody int id) {
        String result = Us.conncetedUtilisateur(id);
        System.out.println(result);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/utilisateurs/add")
    public void AddUtilisateur(@RequestBody Utilisateur newUtilisateur){
        Us.addNewUtilisateur(newUtilisateur);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "utilisateurs/{id}")
    public void updateUtilisateur(@RequestBody Utilisateur utilisateurUpdated, @PathVariable int id){
        Us.updateUtilisateur(id, utilisateurUpdated) ;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "utilisateurs/{id}")
    public void deleteUtilisateur(@PathVariable int id){
        Us.deleteUtilisateur(id);
    }




}
