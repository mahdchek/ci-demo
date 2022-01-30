package com.example.ci;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api")
public class CiController {

    private final CiService ciService;

    public CiController(CiService ciService) {
        this.ciService = ciService;
    }


    @GetMapping("users")
    public List<Utilisateur> test() {
        return ciService.getAllUeres();
    }
}
