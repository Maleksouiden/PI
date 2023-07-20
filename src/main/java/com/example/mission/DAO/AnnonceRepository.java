package com.example.mission.DAO;

import com.example.mission.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
}
