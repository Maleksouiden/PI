package com.example.mission.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Utilisateur {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_utilisateur ;
    private String nom_utilisateur ;
    private String prenom_utilisateur ;
    private String login_utilisateur ;
    private String password_utilisateur ;

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore
    private List<Annonce> annonces;

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore
    private List<Publication> publications;

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore
    private List<Reclamation> reclamations;

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore
    private List<Avis> avis;

}


