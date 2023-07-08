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
import pe.com.fitfuel.dto.CitaDTO;
import pe.com.fitfuel.services.CitaService;

@RestController
@RequestMapping("/api/v1/cita")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @GetMapping("/list")
    public ResponseEntity<List<CitaDTO>> getAllCitas(){
        
        List<CitaDTO> citas = citaService.findAll();
        return ResponseEntity.ok(citas);

    }
    @GetMapping("/{id}")
    public ResponseEntity<CitaDTO> getCitaById(@PathVariable Long id){
        CitaDTO cita = citaService.findById(id);

        if (cita != null) {
            return ResponseEntity.ok(cita);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<CitaDTO> addCita(@RequestBody @Valid CitaDTO citaDTO, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        CitaDTO nuevaCita = citaService.add(citaDTO);
        return ResponseEntity.created(URI.create("/api/v1/cita/" + nuevaCita.getCitaId())).body(nuevaCita);
    }
    @PutMapping("/{id}/edit")
    public ResponseEntity<CitaDTO> updateCita(@PathVariable Long id, @RequestBody @Valid CitaDTO citaDTO, BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        CitaDTO citaActualizada = citaService.update(id, citaDTO);
        if (citaActualizada != null) {
            return ResponseEntity.ok(citaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteCita(@PathVariable Long id){
        citaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
