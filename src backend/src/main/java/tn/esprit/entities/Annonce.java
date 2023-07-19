package tn.esprit.entities;


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
public class Annonce {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_annonce ;
    private String description ;
    private String lieu ;
    private String dimension ;
    private String etat ;
    private int prix ;
    private Date date_creation ;
    @ManyToOne
    @JsonIgnore
    private Utilisateur utilisateur;
    @ManyToOne
    @JsonIgnore
    private Contact contact ;
}
