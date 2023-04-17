package br.com.fiap.GreenHouse.controllers;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
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

import br.com.fiap.GreenHouse.model.Poder;
import br.com.fiap.GreenHouse.repositories.PoderRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("greenhouse/api/power")
public class PoderController {

    Logger log = LoggerFactory.getLogger(PoderController.class);

    @Autowired
    PoderRepository repository;
    
    @GetMapping()
    public Page<Poder> index(@PageableDefault(size = 10) Pageable pageable){
        return repository.findAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Poder> show(@PathVariable Long id){
        log.info("Buscar poder por id");
        return ResponseEntity.ok(getPoder(id));
    }

    @PostMapping()
    public ResponseEntity<Poder> create(@RequestBody @Valid Poder poder){
        log.info("Cadastrar um poder");
        repository.save(poder);
        return ResponseEntity.status(HttpStatus.CREATED).body(poder);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Poder> delete(@PathVariable Long id){
        log.info("Deletar poder por id " + id);
        repository.delete(getPoder(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Poder> update(@PathVariable Long id, @RequestBody @Valid Poder poder){
        log.info("Atualizar poder por id " + id);
        getPoder(id);
        poder.setId(id);
        repository.save(poder);
        return ResponseEntity.ok(poder);
    }

    private Poder getPoder(Long id) {
        return repository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Poder não existente")
        );  
    }

}
