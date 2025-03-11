package com.ecole.etudiant.etudiant_service.repository;


import com.ecole.etudiant.etudiant_service.models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}