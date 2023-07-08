package pe.com.fitfuel.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.fitfuel.dto.CitaDTO;
import pe.com.fitfuel.entities.Cita;
import pe.com.fitfuel.repositories.CitaRepository;

@Service
public class CitaServiceImpl implements CitaService{

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CitaDTO> findAll() {
        List<Cita> citas = citaRepository.findAll();
        return citas.stream().map(cita -> modelMapper.map(cita, CitaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CitaDTO findById(Long id) {
        Cita cita = citaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cita no encontrada con ID: " + id));
        return modelMapper.map(cita, CitaDTO.class);
    }

    @Override
    public CitaDTO add(CitaDTO citaDTO) {
        Cita cita = modelMapper.map(citaDTO, Cita.class);
        Cita citaGuardada = citaRepository.save(cita);
        return modelMapper.map(citaGuardada, CitaDTO.class);
    }

    @Override
    public CitaDTO update(Long id, CitaDTO citaDTO) {
        Cita citaExistente = citaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cita no encontrada con ID: " + id));

        modelMapper.map(citaDTO, citaExistente);

        Cita citaActualizada = citaRepository.save(citaExistente);
        return modelMapper.map(citaActualizada, CitaDTO.class);
    }

    @Override
    public void delete(Long id) {
        citaRepository.deleteById(id);
    }
    
}
