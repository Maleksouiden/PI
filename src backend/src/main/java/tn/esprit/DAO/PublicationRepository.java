package tn.esprit.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.entities.Commentaire;
import tn.esprit.entities.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Integer> {
}
