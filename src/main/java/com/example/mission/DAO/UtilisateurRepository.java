package com.example.mission.DAO;

import com.example.mission.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
}
