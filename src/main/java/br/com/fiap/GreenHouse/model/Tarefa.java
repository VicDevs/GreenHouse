package br.com.fiap.GreenHouse.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @NotBlank
    private String nome;
   
    @NotBlank
    private String descricao;
    
    @NotNull
    private int experiencia;
    
    @NotNull
    private int idCategoria;
    
    @NotNull @Past 
    private LocalDate data;

    @NotNull
    private Enum elementos;
}
