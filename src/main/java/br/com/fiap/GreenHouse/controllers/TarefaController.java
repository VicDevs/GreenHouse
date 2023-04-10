package br.com.fiap.GreenHouse.controllers;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.GreenHouse.model.Tarefa;
import br.com.fiap.GreenHouse.repositories.TarefaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/greenhouse/api/tarefa")
public class TarefaController {

    Logger log = LoggerFactory.getLogger(TarefaController.class);

    @Autowired
    TarefaRepository repository;

    @GetMapping()
    public List<Tarefa> index(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Tarefa> show(@PathVariable Long id){
        log.info("Buscar tarefa por id " + id);
        return ResponseEntity.ok(getTarefa(id));
    }

    @PostMapping()
    public ResponseEntity<Tarefa> create(@RequestBody @Valid Tarefa tarefa){
        log.info("Cadastrar uma tarefa " + tarefa);
        repository.save(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Tarefa> delete(@PathVariable Long id){
        log.info("Deletar tarefa por id " + id);
        repository.delete(getTarefa(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PutMapping("{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody @Valid Tarefa tarefa){
        log.info("Atualizar tarefa por id " + id);
        getTarefa(id);
        tarefa.setId(id);
        repository.save(tarefa);
        return ResponseEntity.ok(tarefa);
    }

    public Tarefa getTarefa(@PathVariable Long id){
        return repository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não existente")
        );
    }
}
