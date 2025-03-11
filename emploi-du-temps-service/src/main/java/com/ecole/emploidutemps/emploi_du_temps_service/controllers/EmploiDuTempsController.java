package com.ecole.emploidutemps.emploi_du_temps_service.controllers;



import com.ecole.emploidutemps.emploi_du_temps_service.models.EmploiDuTemps;
import com.ecole.emploidutemps.emploi_du_temps_service.repository.EmploiDuTempsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emplois")
@CrossOrigin(origins = "http://localhost:5173")
public class EmploiDuTempsController {


    @Autowired
    private EmploiDuTempsRepository emploiDuTempsRepository;

    @GetMapping
    public ResponseEntity<List<EmploiDuTemps>> getAllEmplois() {
        List<EmploiDuTemps> emplois = emploiDuTempsRepository.findAll();
        return ResponseEntity.ok(emplois);
    }

    @PostMapping
    public ResponseEntity<EmploiDuTemps> createEmploi(@RequestBody EmploiDuTemps emploi) {
        EmploiDuTemps savedEmploi = emploiDuTempsRepository.save(emploi);
        return ResponseEntity.ok(savedEmploi);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploiDuTemps> getEmploiById(@PathVariable Long id) {
        EmploiDuTemps emploi = emploiDuTempsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Emploi non trouvé "));
        return ResponseEntity.ok(emploi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmploiDuTemps> updateEmploi(@PathVariable Long id, @RequestBody EmploiDuTemps emploiDetails) {
        EmploiDuTemps emploi = emploiDuTempsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Emploi non trouvé "));
        emploi.setCoursId(emploiDetails.getCoursId());
        emploi.setDebut(emploiDetails.getDebut());
        emploi.setFin(emploiDetails.getFin());
        EmploiDuTemps updatedEmploi = emploiDuTempsRepository.save(emploi);
        return ResponseEntity.ok(updatedEmploi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploi(@PathVariable Long id) {
        EmploiDuTemps emploi = emploiDuTempsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Emploi non trouvé "));
        emploiDuTempsRepository.delete(emploi);
        return ResponseEntity.noContent().build();
    }
}