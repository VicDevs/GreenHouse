package br.com.fiap.GreenHouse.model;

import java.time.LocalDate;

public class Tarefa {

   private int id;
   private String nome;
   private String descricao;
   private int experiencia;
   private int idCategoria; 
   private LocalDate data;

public Tarefa(int id, String nome, String descricao, int experiencia, int idCategoria, LocalDate data) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.experiencia = experiencia;
    this.idCategoria = idCategoria;
    this.data = data;
}


public int getId() {
    return id;
}


public void setId(int id) {
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
