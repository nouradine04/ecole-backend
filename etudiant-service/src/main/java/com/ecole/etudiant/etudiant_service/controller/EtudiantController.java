package com.ecole.etudiant.etudiant_service.controller;

import com.ecole.etudiant.etudiant_service.models.Etudiant;
import com.ecole.etudiant.etudiant_service.repository.EtudiantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
@CrossOrigin(origins = "http://localhost:5173")
public class EtudiantController {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        return ResponseEntity.ok(etudiants);
    }

    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        return ResponseEntity.ok(savedEtudiant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Étudiant non trouvé "));
        return ResponseEntity.ok(etudiant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiantDetails) {
        Etudiant etudiant = etudiantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Étudiant non trouvé"));
        etudiant.setNom(etudiantDetails.getNom());
        etudiant.setPrenom(etudiantDetails.getPrenom());
        etudiant.setEmail(etudiantDetails.getEmail());
        Etudiant updatedEtudiant = etudiantRepository.save(etudiant);
        return ResponseEntity.ok(updatedEtudiant);
    }

    protected List<Etudiant> fetchAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Étudiant non trouvé "));
        etudiantRepository.delete(etudiant);
        return ResponseEntity.noContent().build();
    }
}