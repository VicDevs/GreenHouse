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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.GreenHouse.model.Poder;

@RestController
public class PoderController {

    Logger log = LoggerFactory.getLogger(PoderController.class);

    List<Poder> poderes = new ArrayList<>();
    
    @GetMapping("/greenhouse/api/power")
    public List<Poder> index(){
        return poderes;
    }

    @GetMapping("/greenhouse/api/power/{id}")
    public ResponseEntity<Poder> show(@PathVariable Long id){
        log.info("Buscar Poder por id " + id);

        var poderEncontrado = poderes.stream()
                                      .filter((p)-> {return p.getId().equals(id);})
                                      .findFirst();

        if(poderEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(poderEncontrado.get());
    }

    @PostMapping("/greenhouse/api/power")
    public ResponseEntity<Poder> create(@RequestBody Poder poder){
        log.info("Cadastrar um poder");
        poder.setId(poderes.size() + 1l);
        poderes.add(poder);
        return ResponseEntity.status(HttpStatus.CREATED).body(poder);
    }

    @DeleteMapping("/greenhouse/api/power/{id}")
    public ResponseEntity<Poder> delete(@PathVariable Long id){
        log.info("Deletar poder por id " + id);
        var poderEncontrado = poderes.stream()
                                      .filter((p)-> {return p.getId().equals(id);})
                                      .findFirst();
        if(poderEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        poderes.remove(poderEncontrado.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public ResponseEntity<Poder> update(@PathVariable Long id, @RequestBody Poder poder){
        log.info("Atualizar poder por id " + id);
        var poderEncontrado = poderes.stream()
                                     .filter((p)-> {return p.getId().equals(id);})
                                     .findFirst();
        if(poderEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        poderes.remove(poderEncontrado.get());
        poder.setId(id);
        poderes.add(poder);
        return ResponseEntity.ok(poder);
    }

}
