package pe.com.fitfuel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.fitfuel.entities.Precio;

public interface PrecioRepository extends JpaRepository<Precio, Long> {
    
}
