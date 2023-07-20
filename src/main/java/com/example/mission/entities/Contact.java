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
public class Contact {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_contact ;
    private String num_tel ;
    private String email_contact ;
    @OneToMany(mappedBy = "contact")
    @JsonIgnore
    private List<Annonce> annonces;
}
