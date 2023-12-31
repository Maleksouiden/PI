package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.DAO.CommentaireRepository;
import tn.esprit.entities.Avis;
import tn.esprit.entities.Commentaire;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentaireServices {

    @Autowired
    CommentaireRepository CMRepo ;


    public List<Commentaire> getAllCommentaire(){
        List<Commentaire> commentaires = new ArrayList<>() ;
        CMRepo.findAll().forEach(commentaires::add);
        return commentaires ;
    }

    public String addNewCommantaire(Commentaire commentaire){
        CMRepo.save(commentaire) ;
        return "commentaire ajouter" ;
    }

    public String updateCommentaire(int id, Commentaire commentaire) {
        CMRepo.save(commentaire) ;
        return "commentaire Modifier" ;
    }


    public String deleteCommentaire(int id){
        CMRepo.deleteById(id);
        return "commentaire Supprimer" ;
    }
}
