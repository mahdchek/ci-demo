package com.example.ci;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String role;
    private String login;
    @Transient
    private String password;
}
