package pe.com.fitfuel.services;

import java.util.List;

import pe.com.fitfuel.dto.NutricionistaDTO;

public interface NutricionistaService {
    List<NutricionistaDTO> findAll();
    NutricionistaDTO findById(Long id);
    NutricionistaDTO add(NutricionistaDTO nutricionistaDTO);
    NutricionistaDTO update(Long id, NutricionistaDTO nutricionistaDTO);
    void delete(Long id);
}

