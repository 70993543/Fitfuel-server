package pe.com.fitfuel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.fitfuel.entities.Opinion;

public interface OpinionRepository extends JpaRepository<Opinion, Long>{
    
}
