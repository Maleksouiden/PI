package com.example.mission.services;

import com.example.mission.DAO.AnnonceRepository;
import com.example.mission.entities.Annonce;
import com.example.mission.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnnonceServices {
    @Autowired
    public AnnonceRepository AR ;

    public List<Annonce> getAllAnnonces(){
        List<Annonce> annonces = new ArrayList<>() ;
        AR.findAll().forEach(annonce -> {
            // Charger explicitement les clés étrangères utilisateur et contact

            annonce.getContact();
            annonces.add(annonce);
        });
        return annonces ;
    }

    public String addNewAnnonce(Annonce annonce){
        Utilisateur utilisateur = new Utilisateur();
        annonce.setUtilisateur(utilisateur);
        AR.save(annonce) ;
        return "Annonce ajouter" ;
    }

    public String updateAnnonce(int id, Annonce annonce) {
        AR.save(annonce) ;
        return "Annonce Modifier" ;
    }


    public String deleteAnnonce(int id){
        AR.deleteById(id);
        return "Annonce Supprimer" ;
    }

    public Annonce getSingleAnnonce(int id){
        return AR.findById(id).orElse(null) ;
    }
}
