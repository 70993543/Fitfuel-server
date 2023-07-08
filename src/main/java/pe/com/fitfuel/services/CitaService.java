package pe.com.fitfuel.services;

import java.util.List;

import pe.com.fitfuel.dto.CitaDTO;

public interface CitaService {
    List<CitaDTO> findAll();
    CitaDTO findById(Long id);
    CitaDTO add(CitaDTO citaDTO);
    CitaDTO update(Long id, CitaDTO citaDTO);
    void delete(Long id);
}
