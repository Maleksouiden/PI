package tn.esprit.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Annonce;
import tn.esprit.services.AnnonceServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class AnnonceController {

    @Autowired
    private AnnonceServices As  ;

    @RequestMapping("/annonces")
    public List<Map<String, Object>> getAllAnnonces() {
        List<Map<String, Object>> annonces = new ArrayList<>();

        As.getAllAnnonces().forEach(annonce -> {
            int utilisateurId = annonce.getUtilisateur().getId_utilisateur();

            Map<String, Object> annonceMap = new HashMap<>();
            annonceMap.put("id_annonce", annonce.getId_annonce());
            annonceMap.put("description", annonce.getDescription());
            annonceMap.put("lieu", annonce.getLieu());
            annonceMap.put("dimension", annonce.getDimension());
            annonceMap.put("etat", annonce.getEtat());
            annonceMap.put("prix", annonce.getPrix());
            annonceMap.put("date_creation", annonce.getDate_creation());
            annonceMap.put("utilisateurId", utilisateurId);

            annonces.add(annonceMap);
        });

        return annonces;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/annonces")
    public ResponseEntity<Annonce> addAnnonce(@RequestBody Annonce newAnnonce) {
        As.addNewAnnonce(newAnnonce);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAnnonce);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "annonces/{id}")
    public void updateAnnonce(@RequestBody Annonce annonceUpdated, @PathVariable int id){
        As.updateAnnonce(id, annonceUpdated) ;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "annonces/{id}")
    public void deleteAnnonce(@PathVariable int id){ As.deleteAnnonce(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "annonces/{id}")
    public Annonce getSingleAnnonce(@PathVariable int id){
        return As.getSingleAnnonce(id);
    }

}
