package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.DAO.PublicationRepository;
import tn.esprit.entities.Avis;
import tn.esprit.entities.Publication;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicationServices {

    @Autowired
    PublicationRepository PRepo ;

    public List<Publication> getAllPublications(){
        List<Publication> publications = new ArrayList<>() ;
        PRepo.findAll().forEach(publications::add);
        return publications ;
    }

    public String addNewPublication(Publication publication){
        PRepo.save(publication) ;
        return "Publication ajouter" ;
    }

    public String updatePublication(int id, Publication publication) {
        PRepo.save(publication) ;
        return "Publication Modifier" ;
    }


    public String deletePublication(int id){
        PRepo.deleteById(id);
        return "Publication Supprimer" ;
    }
}
