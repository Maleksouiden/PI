package com.example.mission.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Avis {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_avis ;
    private String contenu_avis ;
    private Date date_avis ;

    @ManyToOne
    @JsonIgnore
    private Utilisateur utilisateur;

}
