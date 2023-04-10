package br.com.fiap.GreenHouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank @Pattern(regexp = "^\\S+\\s\\S+(\\s\\S+)*$")
    private String nome;

    @NotBlank 
    @Size(min = 8) 
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*]).+$")
    private String senha;

    @NotNull
    private int xp;

    @NotNull
    private int level;

    @ManyToMany
    private Local local;

    @OneToMany
    private Tarefa tarefa;

    @NotNull
    private int rank;
}
