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
public class Reclamation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_reclamation ;
    private String contenu_reclamation ;
    private Date date_reclamation ;
    @ManyToOne
    @JsonIgnore
    private Utilisateur utilisateur;
}
