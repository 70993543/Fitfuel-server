package pe.com.fitfuel.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pe.com.fitfuel.entities.Nutricionista;
import pe.com.fitfuel.entities.Objetivo;
import pe.com.fitfuel.entities.Precio;
import pe.com.fitfuel.repositories.NutricionistaRepository;
import pe.com.fitfuel.repositories.ObjetivoRepository;
import pe.com.fitfuel.repositories.PrecioRepository;

@Component
public class NutricionistaCommnadLinnerRunner implements CommandLineRunner{

    @Autowired
    private NutricionistaRepository nutricionistaRepository;
    @Autowired
    private ObjetivoRepository objetivoRepository;
    @Autowired
    private PrecioRepository precioRepository;

    @Override
    public void run(String... args) throws Exception {
        Objetivo objetivo1 = objetivoRepository.findById(1L).orElse(null);

        // .orElseThrow(()->new RuntimeException("categoria no encontrada"));
        Precio precio1 = precioRepository.findById(1L).orElse(null);

        Nutricionista nutricionista1 = new Nutricionista(
            "Ana", "Salazar", "https://images.pexels.com/photos/16999877/pexels-photo-16999877/free-photo-of-gente-mujer-relajacion-conexion.jpeg","mMYTKrzcuoU","Nutricionista", "Soy nutricionista licenciado en la Universidad Cayatano Heredia cuento con 5 años de experiencia en este rubro"
        );
        nutricionista1.setObjetivo(objetivo1);
        nutricionista1.setPrecio(precio1);

        nutricionistaRepository.save(nutricionista1);

    }
    
}
