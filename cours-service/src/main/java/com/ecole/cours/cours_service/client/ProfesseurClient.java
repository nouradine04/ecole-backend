package com.ecole.cours.cours_service.client;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProfesseurClient {

    @Autowired
    private RestTemplate restTemplate;

    public ProfesseurDTO getProfesseur(Long id) {
        String url = "http://localhost:8082/api/professeurs/" + id;
        return restTemplate.getForObject(url, ProfesseurDTO.class);
    }
}

@Data
class ProfesseurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String specialite;
}