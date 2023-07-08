package pe.com.fitfuel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.fitfuel.entities.Nutricionista;

public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long>{
    
}
