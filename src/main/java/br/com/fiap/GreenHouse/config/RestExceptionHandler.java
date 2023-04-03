package br.com.fiap.GreenHouse.config;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.GreenHouse.model.RestErrors;

public class RestExceptionHandler {
    Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<RestErrors>> constrainViolationExceptionHandler (ConstraintViolationException e){
        log.error("Erro capturado");
        List<RestErrors> erros = new ArrayList<>();

        e.getConstraintViolations().forEach(v -> erros.add(new RestErrors(v.getPropertyPath().toString(), v.getMessage())));

        return ResponseEntity.badRequest().body(erros);
    }
}
