package pe.com.fitfuel.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.fitfuel.dto.NutricionistaDTO;
import pe.com.fitfuel.entities.Nutricionista;
import pe.com.fitfuel.repositories.NutricionistaRepository;

@Service
public class NutricionistaServiceImpl implements NutricionistaService{

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<NutricionistaDTO> findAll() {
        List<Nutricionista> nutricionistas = nutricionistaRepository.findAll();
        return nutricionistas.stream().map(nutricionista -> modelMapper.map(nutricionista, NutricionistaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public NutricionistaDTO findById(Long id) {
        Nutricionista nutricionista = nutricionistaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Nutricionista no encontrada con ID: " + id));
        return modelMapper.map(nutricionista, NutricionistaDTO.class);
    }

    @Override
    public NutricionistaDTO add(NutricionistaDTO nutricionistaDTO) {
        Nutricionista nutricionista = modelMapper.map(nutricionistaDTO, Nutricionista.class);
        Nutricionista nutricionistaGuardado = nutricionistaRepository.save(nutricionista);
        return modelMapper.map(nutricionistaGuardado, NutricionistaDTO.class);
    }

    @Override
    public NutricionistaDTO update(Long id, NutricionistaDTO nutricionistaDTO) {
        Nutricionista nutricionistaExistente = nutricionistaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Nutricionista no encontrado con ID: " + id));
        modelMapper.map(nutricionistaDTO, nutricionistaExistente);
        Nutricionista nutricionistaActualizado = nutricionistaRepository.save(nutricionistaExistente);
        return modelMapper.map(nutricionistaActualizado, NutricionistaDTO.class);
    }

    @Override
    public void delete(Long id) {
        nutricionistaRepository.deleteById(id);
    }
    
}
