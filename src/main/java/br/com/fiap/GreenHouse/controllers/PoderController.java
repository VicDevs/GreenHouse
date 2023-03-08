package br.com.fiap.GreenHouse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.GreenHouse.model.Poder;

@RestController
public class PoderController {
    
    @GetMapping("/greenhouse/api/power")
    public Poder gPoder(){
        Poder poder = new Poder(
            1,
            1,
            "Queime uma tarefa e deixe que alguem faça por você",
            20);
        return poder;
    }
}
