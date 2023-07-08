package pe.com.fitfuel.initializer;

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
        Objetivo objetivo1 = new Objetivo(
            "Bajar de peso"
        );
        objetivoRepository.save(objetivo1);
    }
    
}
