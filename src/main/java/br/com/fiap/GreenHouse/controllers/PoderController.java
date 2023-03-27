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

import br.com.fiap.GreenHouse.model.Poder;
import br.com.fiap.GreenHouse.repositories.PoderRepository;

@RestController
public class PoderController {

    Logger log = LoggerFactory.getLogger(PoderController.class);

    @Autowired
    PoderRepository repository;
    
    @GetMapping("/greenhouse/api/power")
    public List<Poder> index(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Poder> show(@PathVariable Long id){
        log.info("Buscar Poder por id " + id);
        var poderEncontrado = repository.findById(id);

        if(poderEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(poderEncontrado.get());
    }

    @PostMapping("/greenhouse/api/power")
    public ResponseEntity<Poder> create(@RequestBody Poder poder){
        log.info("Cadastrar um poder");
        repository.save(poder);
        return ResponseEntity.status(HttpStatus.CREATED).body(poder);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Poder> delete(@PathVariable Long id){
        log.info("Deletar poder por id " + id);
        
        var poderEncontrado = repository.findById(id);
        
        if(poderEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        repository.delete(poderEncontrado.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Poder> update(@PathVariable Long id, @RequestBody Poder poder){
        log.info("Atualizar poder por id " + id);
        
        var poderEncontrado = repository.findById(id);
        var novoPoder = poderEncontrado.get();
        BeanUtils.copyProperties(poder, novoPoder, "id");

        repository.save(novoPoder);
        
        return ResponseEntity.ok(novoPoder);
    }

}
