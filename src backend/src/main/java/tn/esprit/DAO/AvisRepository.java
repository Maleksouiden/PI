package tn.esprit.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.entities.Avis;

public interface AvisRepository extends JpaRepository<Avis, Integer> {
}
