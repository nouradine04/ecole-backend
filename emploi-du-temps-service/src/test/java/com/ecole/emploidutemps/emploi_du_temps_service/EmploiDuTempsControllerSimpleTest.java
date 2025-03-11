package com.ecole.emploidutemps.emploi_du_temps_service;


import com.ecole.emploidutemps.emploi_du_temps_service.controllers.EmploiDuTempsController;
import com.ecole.emploidutemps.emploi_du_temps_service.models.EmploiDuTemps;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmploiDuTempsControllerSimpleTest {

    @Test
    public void testGetAllEmploisEmptyList() {
        List<EmploiDuTemps> emploisSimules = new ArrayList<>();
        EmploiDuTempsController controller = new EmploiDuTempsController() {
            @Override
            protected List<EmploiDuTemps> fetchAllEmplois() {
                return emploisSimules;
            }
        };

        ResponseEntity<List<EmploiDuTemps>> response = controller.getAllEmplois();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, response.getBody().size());
    }

    @Test
    public void testGetAllEmploisWithData() {
        List<EmploiDuTemps> emploisSimules = new ArrayList<>();
        emploisSimules.add(new EmploiDuTemps(1L, 1L, "2025-03-10T10:00", "2025-03-10T11:00"));

        EmploiDuTempsController controller = new EmploiDuTempsController() {
            @Override
            protected List<EmploiDuTemps> fetchAllEmplois() {
                return emploisSimules;
            }
        };

        ResponseEntity<List<EmploiDuTemps>> response = controller.getAllEmplois();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals("2025-03-10T10:00", response.getBody().get(0).getDebut());
    }
}
