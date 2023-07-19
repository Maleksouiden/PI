package tn.esprit.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.entities.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
}
