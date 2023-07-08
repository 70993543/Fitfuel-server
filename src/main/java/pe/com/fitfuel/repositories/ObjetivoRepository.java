package pe.com.fitfuel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.fitfuel.entities.Objetivo;

public interface ObjetivoRepository extends JpaRepository<Objetivo, Long>{
    
}
