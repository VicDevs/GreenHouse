package br.com.fiap.GreenHouse.controllers;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.GreenHouse.model.Tarefa;

@RestController
public class TarefaController {

    Logger log = LoggerFactory.getLogger(TarefaController.class);

    List<Tarefa> tarefas = new ArrayList<>();

    @GetMapping("/greenhouse/api/tarefa")
    public List<Tarefa> index(){
        return tarefas;
    }

    @GetMapping("/greenhouse/api/tarefa/{id}")
    public ResponseEntity<Tarefa> show(@PathVariable Long id){
        log.info("Buscar tarefa por id " + id);
        
        var tarefaEncontrada = tarefas.stream()
                                      .filter((t)-> {return t.getId().equals(id);})
                                      .findFirst();

        if(tarefaEncontrada.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        return ResponseEntity.ok(tarefaEncontrada.get());
    }

    @PostMapping("/greenhouse/api/tarefa")
    public ResponseEntity<Tarefa> create(@RequestBody Tarefa tarefa){
        log.info("Cadastrar uma tarefa");
        tarefa.setId(tarefas.size() + 1l);
        tarefas.add(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }

    @DeleteMapping("/greenhouse/api/tarefa/{id}")
    public ResponseEntity<Tarefa> delete(@PathVariable Long id){
        log.info("Deletar tarefa por id " + id);
        var tarefaEncontrada = tarefas.stream()
                                      .filter((t)-> {return t.getId().equals(id);})
                                      .findFirst();

        if(tarefaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        tarefas.remove(tarefaEncontrada.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PutMapping("/greenhouse/api/tarefa/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody Tarefa tarefa){
        log.info("Atualizar tarefa por id " + id);
        var tarefaEncontrada = tarefas.stream()
                                      .filter((t)-> {return t.getId().equals(id);})
                                      .findFirst();

        if(tarefaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        tarefas.remove(tarefaEncontrada.get());
        tarefa.setId(id);
        tarefas.add(tarefa);
        return ResponseEntity.ok(tarefa);
    }
    
}
