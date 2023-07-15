package pe.com.fitfuel.initializer;

import java.util.ArrayList;
import java.util.List;

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
        guardarVariosPrecios();
    }
    private void guardarVariosPrecios() {
        List<Precio> precios = new ArrayList<>();

        Precio precio1 = new Precio(200.00);
        precios.add(precio1);

        Precio precio2 = new Precio(150.00);
        precios.add(precio2);

        Precio precio3 = new Precio(300.00);
        precios.add(precio3);

        Precio precio4 = new Precio(250.00);
        precios.add(precio4);

        Precio precio5 = new Precio(180.00);
        precios.add(precio5);

        Precio precio6 = new Precio(350.00);
        precios.add(precio6);

        precioRepository.saveAll(precios);
    }

    private void eliminarTodosLosPrecios() {
        precioRepository.deleteAll();
    }
    
}
