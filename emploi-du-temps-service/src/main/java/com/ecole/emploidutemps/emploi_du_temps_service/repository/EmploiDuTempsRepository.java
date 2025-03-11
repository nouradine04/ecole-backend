package com.ecole.emploidutemps.emploi_du_temps_service.repository;

import com.ecole.emploidutemps.emploi_du_temps_service.models.EmploiDuTemps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploiDuTempsRepository extends JpaRepository<EmploiDuTemps, Long> {
}
