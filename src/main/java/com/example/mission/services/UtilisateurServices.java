package com.example.mission.services;

import com.example.mission.DAO.UtilisateurRepository;
import com.example.mission.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder ;

import java.util.ArrayList;
import java.util.List;


@Service
public class UtilisateurServices {

    @Autowired
    public UtilisateurRepository UR ;

    @Autowired
    public PasswordEncoder passwordEncoder ;

    public List<Utilisateur> getAllUtilisateurs(){
        List<Utilisateur> utilisateurs = new ArrayList<>() ;
        UR.findAll().forEach(utilisateurs::add);
        return utilisateurs ;
    }

    public String addNewUtilisateur(Utilisateur utilisateur){

        // Utilisateur newUtilisateur = new Utilisateur(
        //        utilisateur.getId_utilisateur() ,
        //        utilisateur.getNom_utilisateur(),
        //        utilisateur.getPrenom_utilisateur() ,
        //        utilisateur.getLogin_utilisateur(),
        //        this.passwordEncoder.encode(utilisateur.getPassword_utilisateur()) ,
        //        utilisateur.getAnnonces(),
        //       utilisateur.getPublications(),
        //        utilisateur.getReclamations(),
        //        utilisateur.getAvis()
        // );
        UR.save(utilisateur) ;
        return "Utilisateur ajouter" ;
    }

    public String updateUtilisateur(int id, Utilisateur utilisateur) {
        UR.save(utilisateur) ;
        return "Utilisateur Modifier" ;
    }
    public String conncetedUtilisateur(int id) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId_utilisateur(id);
        int utilisateurId = utilisateur.getId_utilisateur();
        System.out.println(utilisateurId);
        return "utilisateur enregistré";
    }

    public String deleteUtilisateur(int id){
        UR.deleteById(id);
        return "utilisateur Supprimer" ;
    }

}
