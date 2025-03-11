package com.ecole.cours.cours_service;



import com.ecole.cours.cours_service.controllers.CoursController;
import com.ecole.cours.cours_service.models.Cours;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoursControllerSimpleTest {

    @Test
    public void testGetAllCoursEmptyList() {
        List<Cours> coursSimules = new ArrayList<>();
        CoursController controller = new CoursController() {
            @Override
            protected List<Cours> fetchAllCours() {
                return coursSimules;
            }
        };

        ResponseEntity<List<Cours>> response = controller.listcours();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, response.getBody().size());
    }

    @Test
    public void testGetAllCoursWithData() {
        List<Cours> coursSimules = new ArrayList<>();
        coursSimules.add(new Cours(1L, "Maths", 1L));

        CoursController controller = new CoursController() {
            @Override
            protected List<Cours> fetchAllCours() {
                return coursSimules;
            }
        };

        ResponseEntity<List<Cours>> response = controller.listcours();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals("Maths", response.getBody().get(0).getTitre());
    }
}