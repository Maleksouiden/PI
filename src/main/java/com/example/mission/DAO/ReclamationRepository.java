package com.example.mission.DAO;

import com.example.mission.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface ReclamationRepository extends JpaRepository<Reclamation, Integer> {
}
