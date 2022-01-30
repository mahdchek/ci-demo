package com.example.ci;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;


@Repository
public interface CiRepository extends JpaRepository<Utilisateur, Long> {
}
