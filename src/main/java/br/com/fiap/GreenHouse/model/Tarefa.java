package br.com.fiap.GreenHouse.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
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


public Tarefa(Long id, String nome, String descricao, int experiencia, int idCategoria, LocalDate data) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.experiencia = experiencia;
    this.idCategoria = idCategoria;
    this.data = data;
}




public Long getId() {
    return id;
}




public void setId(Long id) {
    this.id = id;
}




public String getNome() {
    return nome;
}




public void setNome(String nome) {
    this.nome = nome;
}




public String getDescricao() {
    return descricao;
}




public void setDescricao(String descricao) {
    this.descricao = descricao;
}




public int getExperiencia() {
    return experiencia;
}




public void setExperiencia(int experiencia) {
    this.experiencia = experiencia;
}




public int getIdCategoria() {
    return idCategoria;
}




public void setIdCategoria(int idCategoria) {
    this.idCategoria = idCategoria;
}




public LocalDate getData() {
    return data;
}




public void setData(LocalDate data) {
    this.data = data;
}




@Override
public String toString() {
    return "Tarefa [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", experiencia=" + experiencia
            + ", idCategoria=" + idCategoria + ", data=" + data + "]";
}
   
}
