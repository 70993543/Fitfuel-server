package pe.com.fitfuel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.fitfuel.entities.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long>{
    
}
