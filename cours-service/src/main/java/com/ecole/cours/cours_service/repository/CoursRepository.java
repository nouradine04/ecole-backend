package com.ecole.cours.cours_service.repository;


import com.ecole.cours.cours_service.models.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}