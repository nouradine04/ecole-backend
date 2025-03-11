package com.ecole.cours.cours_service.controllers;


import com.ecole.cours.cours_service.client.ProfesseurClient;
import com.ecole.cours.cours_service.models.Cours;

import com.ecole.cours.cours_service.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cours")
@CrossOrigin(origins = "http://localhost:5173")
public abstract class CoursController {
    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private ProfesseurClient professeurClient;


    @GetMapping
    public ResponseEntity<List<Cours>> listcours() {
        List<Cours> cours = coursRepository.findAll();
        return ResponseEntity.ok(cours);
    }


    @PostMapping
    public ResponseEntity<Cours> creerCours(@RequestBody Cours cours) {
        Cours savedCours = coursRepository.save(cours);
        return ResponseEntity.ok(savedCours);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cours> getCoursById(@PathVariable Long id) {
        Cours cours = coursRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Étudiant non trouvé avec l'ID : " + id));
        return ResponseEntity.ok(cours);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cours> updateCours(@PathVariable Long id, @RequestBody Cours coursDetails) {
        Cours cours = coursRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cours non trouvé avec l'ID : " + id));
        cours.setTitre(coursDetails.getTitre());
        cours.setProfesseurId(coursDetails.getProfesseurId());
        Cours updateCours = coursRepository.save(cours);
        return ResponseEntity.ok(updateCours);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCours(@PathVariable Long id) {
        Cours cours = coursRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cours non trouvé avec l'ID : " + id));
        coursRepository.delete(cours);
        return ResponseEntity.noContent().build();
    }


    protected abstract List<Cours> fetchAllCours();
}
