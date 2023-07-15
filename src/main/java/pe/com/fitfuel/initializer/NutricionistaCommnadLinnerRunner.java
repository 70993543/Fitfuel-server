package pe.com.fitfuel.initializer;

import java.util.ArrayList;
import java.util.List;

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
        /* agregarNutricionistas(); */
       agregarNutricionistas();

    }
    private void agregarNutricionistas() {
        Objetivo objetivo1 = objetivoRepository.findById(1L).orElse(null);
        Precio precio1 = precioRepository.findById(1L).orElse(null);

        List<Nutricionista> nutricionistas = new ArrayList<>();

        Nutricionista nutricionista1 = new Nutricionista(
        "Ana", "Salazar", "https://images.pexels.com/photos/16999877/pexels-photo-16999877/free-photo-of-gente-mujer-relajacion-conexion.jpeg",
        "mMYTKrzcuoU", "Nutricionista",
        "Soy nutricionista licenciado en la Universidad Cayetano Heredia cuento con 5 años de experiencia en este rubro",
        "123456789", "ana.salazar", "anasalazar", "ana.salazar", objetivo1, precio1
);
        nutricionistas.add(nutricionista1);

        Objetivo objetivo2 = objetivoRepository.findById(2L).orElse(null);
        Precio precio2 = precioRepository.findById(2L).orElse(null);

        Nutricionista nutricionista2 = new Nutricionista(
        "Lorena", "García", "https://images.pexels.com/photos/2726111/pexels-photo-2726111.jpeg",
        "uXodXQ6GR2A", "Nutricionista",
        "Soy un nutricionista certificado con especialización en nutrición deportiva",
        "987654321", "lorena.garcia", "lorenagarcia", "lorena.garcia", objetivo2, precio2
);
       
        nutricionistas.add(nutricionista2);

        Objetivo objetivo3 = objetivoRepository.findById(3L).orElse(null);
        Precio precio3 = precioRepository.findById(3L).orElse(null);
        Nutricionista nutricionista3 = new Nutricionista(
        "Laura", "Hernández", "https://images.pexels.com/photos/3759097/pexels-photo-3759097.jpeg",
        "ABC123", "Nutricionista",
        "Soy nutricionista con experiencia en el tratamiento de trastornos alimentarios",
        "456789123", "laura.hernandez", "laurahernandez", "laura.hernandez", objetivo3, precio3
);
        
        nutricionistas.add(nutricionista3);

        Objetivo objetivo4 = objetivoRepository.findById(4L).orElse(null);
        Precio precio4 = precioRepository.findById(4L).orElse(null);

        Nutricionista nutricionista4 = new Nutricionista(
            "Sara", "López", "https://images.pexels.com/photos/16999877/pexels-photo-16999877/free-photo-of-gente-mujer-relajacion-conexion.jpeg",
            "XYZ789", "Nutricionista",
            "Tengo una pasión por ayudar a las personas a llevar un estilo de vida saludable",
            "789123456", "sara.lopez", "saralopez", "sara.lopez", objetivo4, precio4
    );
        nutricionistas.add(nutricionista4);
        // Agregar más nutricionistas según sea necesario...

        nutricionistaRepository.saveAll(nutricionistas);
    }
    private void borrarTodoLosNutricionistas(){
        nutricionistaRepository.deleteAll();
    }
}
