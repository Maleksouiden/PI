package com.example.mission.DAO;

import com.example.mission.entities.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AvisRepository extends JpaRepository<Avis, Integer> {
}
