package tn.esprit.entities;

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
public class Publication {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_pub ;
    @ManyToOne
    @JsonIgnore
    private Utilisateur utilisateur;
    @OneToMany(mappedBy = "publication")
    @JsonIgnore
    private List<Commentaire> commentaires;
}
