package com.example.mission.DAO;

import com.example.mission.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
}
