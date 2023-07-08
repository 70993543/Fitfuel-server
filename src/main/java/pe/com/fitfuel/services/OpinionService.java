package pe.com.fitfuel.services;

import java.util.List;

import pe.com.fitfuel.dto.OpinionDTO;

public interface OpinionService {
    List<OpinionDTO> findAll();
    OpinionDTO findById(Long id);
    OpinionDTO add(OpinionDTO opinionDTO);
    OpinionDTO update(Long id, OpinionDTO opinionDTO);
    void delete(Long id);
}
