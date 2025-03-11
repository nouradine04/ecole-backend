package com.ecole.emploidutemps.emploi_du_temps_service.models;


import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
@Data
public class EmploiDuTemps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public Long getCoursId() {
        return coursId;
    }

    public LocalDateTime getDebut() {
        return debut;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDebut(LocalDateTime debut) {
        this.debut = debut;
    }

    public void setCoursId(Long coursId) {
        this.coursId = coursId;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    private Long coursId;
    private LocalDateTime debut;
    private LocalDateTime fin;
}
