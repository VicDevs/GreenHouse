package br.com.fiap.GreenHouse.controllers;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.fiap.GreenHouse.repositories.TarefaRepository;

@RestController
public class TarefaController {

    Logger log = LoggerFactory.getLogger(TarefaController.class);

    @Autowired
    TarefaRepository repository;

    @GetMapping("/greenhouse/api/tarefa")
    public List<Tarefa> index(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Tarefa> show(@PathVariable Long id){
        log.info("Buscar tarefa por id " + id);
        var tarefaEncontrada = repository.findById(id);

        if(tarefaEncontrada.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        return ResponseEntity.ok(tarefaEncontrada.get());
    }

    @PostMapping("/greenhouse/api/tarefa")
    public ResponseEntity<Tarefa> create(@RequestBody Tarefa tarefa){
        log.info("Cadastrar uma tarefa " + tarefa);
        repository.save(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Tarefa> delete(@PathVariable Long id){
        log.info("Deletar tarefa por id " + id);
        var tarefaEncontrada = repository.findById(id);

        if(tarefaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repository.delete(tarefaEncontrada.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PutMapping("{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody Tarefa tarefa){
        log.info("Atualizar tarefa por id " + id);
        var tarefaEncontrada = repository.findById(id);

        if(tarefaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        var novaTarefa = tarefaEncontrada.get();
        BeanUtils.copyProperties(tarefa, novaTarefa,"id");
        return ResponseEntity.ok(tarefa);
    }
    
}
