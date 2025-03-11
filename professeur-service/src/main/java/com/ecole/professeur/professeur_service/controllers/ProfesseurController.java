package com.ecole.professeur.professeur_service.controllers;

import com.ecole.professeur.professeur_service.models.Professeur;
import com.ecole.professeur.professeur_service.repository.ProfesseurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professeurs")
@CrossOrigin(origins = "http://localhost:5173")
public abstract class ProfesseurController {

    private static final Logger logger = LoggerFactory.getLogger(ProfesseurController.class);

    @Autowired
    private ProfesseurRepository professeurRepository;

    @GetMapping
    public ResponseEntity<List<Professeur>> getAllProfesseurs() {
        List<Professeur> professeurs = professeurRepository.findAll();
        //logger.info("Nombre de professeurs récupérés : {}", professeurs.size());
       // logger.info("Contenu de la liste : {}", professeurs);
        return ResponseEntity.ok(professeurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professeur> getProfesseurById(@PathVariable Long id) {
        Professeur professeur = professeurRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Professeur non trouvé "));
        return ResponseEntity.ok(professeur);
    }

    @PostMapping
    public ResponseEntity<Professeur> createProfesseur(@RequestBody Professeur professeur) {
        Professeur savedProfesseur = professeurRepository.save(professeur);
        return ResponseEntity.ok(savedProfesseur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professeur> updateProfesseur(@PathVariable Long id, @RequestBody Professeur professeurDetails) {
        Professeur professeur = professeurRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Professeur non trouvé "));
        professeur.setNom(professeurDetails.getNom());
        professeur.setPrenom(professeurDetails.getPrenom());
        professeur.setSpecialite(professeurDetails.getSpecialite());
        Professeur updatedProfesseur = professeurRepository.save(professeur);
        logger.info("Professeur mis à jour : {}", updatedProfesseur);
        return ResponseEntity.ok(updatedProfesseur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfesseur(@PathVariable Long id) {
        Professeur professeur = professeurRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Professeur non trouvé "));
        professeurRepository.delete(professeur);
        return ResponseEntity.noContent().build();
    }

    protected abstract List<Professeur> fetchAllProfesseurs();
}