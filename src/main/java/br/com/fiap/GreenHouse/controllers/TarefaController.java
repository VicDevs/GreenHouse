package br.com.fiap.GreenHouse.controllers;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.GreenHouse.model.Tarefa;

@RestController
public class TarefaController {
    @GetMapping("/greenhouse/api/tarefa")
    public Tarefa gTarefa(){
        Tarefa tarefa = new Tarefa(
            1,
            "Organizar Quarto",
            "Varrer, passar pano, guardar roupa, etc",
            10,
            1,
            LocalDate.now()
        );
        return tarefa;
    }
}
