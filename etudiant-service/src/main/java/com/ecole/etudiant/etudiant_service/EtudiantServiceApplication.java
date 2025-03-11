package com.ecole.etudiant.etudiant_service;
import com.ecole.etudiant.etudiant_service.repository.EtudiantRepository;

import com.ecole.etudiant.etudiant_service.models.Etudiant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EtudiantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtudiantServiceApplication.class, args);
	}


}
