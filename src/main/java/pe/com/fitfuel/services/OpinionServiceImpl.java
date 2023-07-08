package pe.com.fitfuel.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.fitfuel.dto.OpinionDTO;
import pe.com.fitfuel.entities.Opinion;
import pe.com.fitfuel.repositories.OpinionRepository;

@Service
public class OpinionServiceImpl implements OpinionService{

    @Autowired
    private OpinionRepository opinionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<OpinionDTO> findAll() {
        List<Opinion> opiniones = opinionRepository.findAll();
        return opiniones.stream().map(opinion -> modelMapper.map(opinion, OpinionDTO.class)).collect(Collectors.toList());

    }

    @Override
    public OpinionDTO findById(Long id) {
        Opinion opinion = opinionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Opinion no encontrada con ID: " + id));
        return modelMapper.map(opinion, OpinionDTO.class);
    }

    @Override
    public OpinionDTO add(OpinionDTO opinionDTO) {
        Opinion opinion = modelMapper.map(opinionDTO, Opinion.class);
        Opinion opinionGuardada = opinionRepository.save(opinion);
        return modelMapper.map(opinionGuardada, OpinionDTO.class);
    }

    @Override
    public OpinionDTO update(Long id, OpinionDTO opinionDTO) {
        Opinion opinionExistente = opinionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Opinion no encontrada con ID: " + id));
        modelMapper.map(opinionDTO, opinionExistente);

        Opinion opinionActualizada = opinionRepository.save(opinionExistente);
        return modelMapper.map(opinionActualizada, OpinionDTO.class);
    }

    @Override
    public void delete(Long id) {
        opinionRepository.deleteById(id);
    }
    
}
