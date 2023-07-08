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
import pe.com.fitfuel.dto.NutricionistaDTO;
import pe.com.fitfuel.services.NutricionistaService;

@RestController
@RequestMapping("/api/v1/nutricionista")
public class NutricionistaController {
    @Autowired
    private NutricionistaService nutricionistaService;

    @GetMapping("/list")
    public ResponseEntity<List<NutricionistaDTO>> getAllNutricionistas(){
        List<NutricionistaDTO> nutricionistas = nutricionistaService.findAll();
        return ResponseEntity.ok(nutricionistas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NutricionistaDTO> getNutricionistaById(@PathVariable Long id){
        NutricionistaDTO nutricionista = nutricionistaService.findById(id);

        if (nutricionista != null) {
            return ResponseEntity.ok(nutricionista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<NutricionistaDTO> addNutricionista(@RequestBody @Valid NutricionistaDTO nutricionistaDTO, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        NutricionistaDTO nuevoNutricionista = nutricionistaService.add(nutricionistaDTO);
        return ResponseEntity.created(URI.create("/api/v1/nutricionista/" + nuevoNutricionista.getNutricionista_id())).body(nuevoNutricionista);
    }
    @PutMapping("/{id}/edit")
    public ResponseEntity<NutricionistaDTO> updateNutricionista(@PathVariable Long id, @RequestBody @Valid NutricionistaDTO nutricionistaDTO, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        NutricionistaDTO nutricionistaActualizado = nutricionistaService.update(id, nutricionistaDTO);
        if (nutricionistaActualizado != null) {
            return ResponseEntity.ok(nutricionistaActualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteNutricionista(@PathVariable Long id){
        nutricionistaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
