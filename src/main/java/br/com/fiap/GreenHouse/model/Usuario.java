package br.com.fiap.GreenHouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank @Pattern(regexp = "^\\S+\\s\\S+(\\s\\S+)*$")
    private String nome;
    @NotBlank @Pattern(regexp = "^[a-zA-Z0-9_]+$")
    private String senha;
    @NotNull
    private int xp;
    @NotNull
    private int level;

    public Usuario(int id, String nome, String senha, int xp, int level) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.xp = xp;
        this.level = level;
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
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public int getXp() {
        return xp;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", xp=" + xp + ", level=" + level + "]";
    }

    
}
