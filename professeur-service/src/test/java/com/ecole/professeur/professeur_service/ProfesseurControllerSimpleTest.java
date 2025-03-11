package com.ecole.professeur.professeur_service;

import com.ecole.professeur.professeur_service.controllers.ProfesseurController;
import com.ecole.professeur.professeur_service.models.Professeur;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfesseurControllerSimpleTest {

    @Test
    public void testGetAllProfesseursEmptyList() {
        List<Professeur> profsSimules = new ArrayList<>();
        ProfesseurController controller = new ProfesseurController() {
            @Override
            protected List<Professeur> fetchAllProfesseurs() {
                return profsSimules;
            }
        };

        ResponseEntity<List<Professeur>> response = controller.getAllProfesseurs();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, response.getBody().size());
    }

    @Test
    public void testGetAllProfesseursWithData() {
        List<Professeur> profsSimules = new ArrayList<>();
        profsSimules.add(new Professeur(null, "Durand", "Luc", "luc.durand@example.com"));

        ProfesseurController controller = new ProfesseurController() {
            @Override
            protected List<Professeur> fetchAllProfesseurs() {
                return profsSimules;
            }
        };

        ResponseEntity<List<Professeur>> response = controller.getAllProfesseurs();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals("Durand", response.getBody().get(0).getNom());
    }
}