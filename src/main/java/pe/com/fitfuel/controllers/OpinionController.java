package pe.com.fitfuel.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pe.com.fitfuel.dto.OpinionDTO;
import pe.com.fitfuel.services.OpinionService;

@RestController
@RequestMapping("/opinion")
public class OpinionController {
    @Autowired
    private OpinionService opinionService;

    @GetMapping("/list")
    public ResponseEntity<List<OpinionDTO>> getAllOpiniones(){
        List<OpinionDTO> opiniones = opinionService.findAll();
        return ResponseEntity.ok(opiniones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpinionDTO> getOpinionById(@PathVariable Long id){
        OpinionDTO opinion = opinionService.findById(id);

        if (opinion != null) {
            return ResponseEntity.ok(opinion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<OpinionDTO> addOpinion(@RequestBody @Valid OpinionDTO opinionDTO, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        OpinionDTO nuevaOpinion = opinionService.add(opinionDTO);
        return ResponseEntity.created(URI.create("/api/v1/opinion/" + nuevaOpinion.getOpinionId())).body(nuevaOpinion);
    }
    @PutMapping("/{id}/edit")
    public ResponseEntity<OpinionDTO> updateOpinion(@PathVariable Long id, @RequestBody @Valid OpinionDTO opinionDTO, BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        OpinionDTO opinionActualizada = opinionService.update(id, opinionDTO);
        if (opinionActualizada != null) {
            return ResponseEntity.ok(opinionActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteOpinion(@PathVariable Long id){
        opinionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
