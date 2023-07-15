package pe.com.fitfuel.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NutricionistaDTO {
    private Long nutricionistaId;
    private String nombre;
    private String apellido;
    private String imagen;
    private String videoUrl;
    private String especialidad;
    private String descripcion;
    private String whatsapp;
    private String facebook;
    private String instagram;
    private String linkedin;
    private ObjetivoDTO objetivo;
    private PrecioDTO precio;
}

