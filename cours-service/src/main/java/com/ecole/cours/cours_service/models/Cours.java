package com.ecole.cours.cours_service.models;


import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setProfesseurId(Long professeurId) {
        this.professeurId = professeurId;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }


    public Long getId() {
        return id;
    }

    public Cours(Long id, String titre, Long professeurId) {
        this.id = id;
        this.titre = titre;
        this.professeurId = professeurId;
    }

    public String getTitre() {
        return titre;
    }

    public Long getProfesseurId() {
        return professeurId;
    }

    private String titre;
    private Long professeurId;
}