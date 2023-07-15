package pe.com.fitfuel.initializer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pe.com.fitfuel.entities.Objetivo;
import pe.com.fitfuel.repositories.ObjetivoRepository;

@Component
public class ObjetivoCommandLinnerRunner implements CommandLineRunner {

    @Autowired
    private ObjetivoRepository objetivoRepository;

    @Override
    public void run(String... args) throws Exception {
        
    }
    private void guardarVariosObjetivos() {
        List<Objetivo> objetivos = new ArrayList<>();

        Objetivo objetivo1 = new Objetivo("Bajar de peso");
        objetivos.add(objetivo1);

        Objetivo objetivo2 = new Objetivo("Subir de peso");
        objetivos.add(objetivo2);

        Objetivo objetivo3 = new Objetivo("Nutrición infantil");
        objetivos.add(objetivo3);

        Objetivo objetivo4 = new Objetivo("Problemas crónicos");
        objetivos.add(objetivo4);

        Objetivo objetivo5 = new Objetivo("Masa muscular");
        objetivos.add(objetivo5);

        Objetivo objetivo6 = new Objetivo("Salud general");
        objetivos.add(objetivo6);

        objetivoRepository.saveAll(objetivos);
    }

    private void eliminarTodosLosObjetivos() {
        objetivoRepository.deleteAll();
    }
    
}
