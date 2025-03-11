package com.ecole.etudiant.etudiant_service;

import com.ecole.etudiant.etudiant_service.controller.EtudiantController;
import com.ecole.etudiant.etudiant_service.models.Etudiant;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EtudiantControllerTest {

    @Test
    public void testGetAllEtudiantsEmptyList() {
        // Crée une liste vide manuellement
        List<Etudiant> etudiantsSimules = new ArrayList<>();

        // Instancie le contrôleur
        EtudiantController controller = new EtudiantController() {
            @Override
            public List<Etudiant> fetchAllEtudiants() {
                return etudiantsSimules; // On remplace findAll() par une liste qu’on contrôle
            }
        };

        // Appel de la méthode
        ResponseEntity<List<Etudiant>> response = controller.getAllEtudiants();

        // Vérifications
        assertEquals(200, response.getStatusCodeValue()); // Vérifie que c’est OK
        assertEquals(0, response.getBody().size());       // Vérifie que la liste est vide
    }

    @Test
    public void testGetAllEtudiantsWithData() {
        // Crée une liste avec un étudiant
        List<Etudiant> etudiantsSimules = new ArrayList<>();
        etudiantsSimules.add(new Etudiant(1L, "Dupont", "Jean", "jean.dupont@example.com"));

        // Instancie le contrôleur
        EtudiantController controller = new EtudiantController() {
            @Override
            public List<Etudiant> fetchAllEtudiants() {
                return etudiantsSimules; // Liste avec 1 élément
            }
        };

        // Appel de la méthode
        ResponseEntity<List<Etudiant>> response = controller.getAllEtudiants();

        // Vérifications
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals("Dupont", response.getBody().get(0).getNom());
    }
}
