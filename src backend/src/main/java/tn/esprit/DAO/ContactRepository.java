package tn.esprit.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
