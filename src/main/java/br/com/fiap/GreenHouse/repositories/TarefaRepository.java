package br.com.fiap.GreenHouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.GreenHouse.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
    
}
