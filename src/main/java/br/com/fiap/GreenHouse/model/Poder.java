package br.com.fiap.GreenHouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Poder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int tipo; // Pode ser uma interface ou uma classe TipoPoder ? 
    private String descricao;
    private int elementos;
    
   

    public Poder(Long id, int tipo, String descricao, int elementos) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.elementos = elementos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getElementos() {
        return elementos;
    }

    public void setElementos(int elementos) {
        this.elementos = elementos;
    }

    @Override
    public String toString() {
        return "Poder [id=" + id + ", tipo=" + tipo + ", descricao=" + descricao + ", elementos=" + elementos + "]";
    }
    
}
