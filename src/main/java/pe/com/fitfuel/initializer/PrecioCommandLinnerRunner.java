package pe.com.fitfuel.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pe.com.fitfuel.entities.Precio;
import pe.com.fitfuel.repositories.PrecioRepository;

@Component
public class PrecioCommandLinnerRunner implements CommandLineRunner{
    @Autowired
    private PrecioRepository precioRepository;
    @Override
    public void run(String... args) throws Exception {
        Precio precio1 = new Precio(
            200.00
        );
        precioRepository.save(precio1); 
    }
    
}
