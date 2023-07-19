package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.DAO.AnnonceRepository;
import tn.esprit.DAO.AvisRepository;
import tn.esprit.entities.Annonce;
import tn.esprit.entities.Avis;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvisServices {


    @Autowired
    public AvisRepository AvisRepo ;

    public List<Avis> getAllAvis(){
        List<Avis> avis = new ArrayList<>() ;
        AvisRepo.findAll().forEach(avis::add);
        return avis ;
    }

    public String addNewAvis(Avis avis){
        AvisRepo.save(avis) ;
        return "avis ajouter" ;
    }

    public String updateAvis(int id, Avis avis) {
        AvisRepo.save(avis) ;
        return "avis Modifier" ;
    }


    public String deleteAvis(int id){
        AvisRepo.deleteById(id);
        return "avis Supprimer" ;
    }
}
