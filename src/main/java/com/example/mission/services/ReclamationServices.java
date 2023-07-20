package com.example.mission.services;

import com.example.mission.DAO.ReclamationRepository;
import com.example.mission.entities.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ReclamationServices {

    @Autowired
    ReclamationRepository RERepo ;


    public List<Reclamation> getAllReclamations(){
        List<Reclamation> reclamations = new ArrayList<>() ;
        RERepo.findAll().forEach(reclamations::add);
        return reclamations ;
    }

    public String addNewReclamation(Reclamation reclamation){
        RERepo.save(reclamation) ;
        return "Reclamation ajouter" ;
    }

    public String updateReclamation(int id, Reclamation reclamation) {
        RERepo.save(reclamation) ;
        return "Reclamation Modifier" ;
    }


    public String deleteReclamation(int id){
        RERepo.deleteById(id);
        return "Reclamation Supprimer" ;
    }
}
