package com.ecole.professeur.professeur_service.repository;


import com.ecole.professeur.professeur_service.models.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
}