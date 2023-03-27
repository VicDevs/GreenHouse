package br.com.fiap.GreenHouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.GreenHouse.model.Poder;

public interface PoderRepository extends JpaRepository<Poder, Long>{
    
}
