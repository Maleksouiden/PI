package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Avis;
import tn.esprit.entities.Commentaire;
import tn.esprit.services.AvisServices;
import tn.esprit.services.CommentaireServices;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class CommentaireController {

    @Autowired
    private CommentaireServices CS  ;

    @RequestMapping("/commentaires")
    public List<Commentaire> getAllComment(){
        return CS.getAllCommentaire() ;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/commentaires")
    public void AddComment(@RequestBody Commentaire commentaire){
        CS.addNewCommantaire(commentaire);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "commentaires/{id}")
    public void updateComment(@RequestBody Commentaire commentaire, @PathVariable int id){
        CS.updateCommentaire(id, commentaire) ;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "commentaires/{id}")
    public void deleteComment(@PathVariable int id){ CS.deleteCommentaire(id);
    }
}
