package com.example.ci;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiService {

    private final CiRepository ciRepository;

    public CiService(CiRepository ciRepository) {
        this.ciRepository = ciRepository;
    }


    public List<Utilisateur> getAllUeres() {
        return ciRepository.findAll();
    }
}
