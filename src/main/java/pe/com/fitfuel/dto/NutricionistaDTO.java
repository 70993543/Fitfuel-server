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
    
    public NutricionistaDTO(String nombre, String apellido, String imagen, String videoUrl, String especialidad,
            String descripcion, String whatsapp, String facebook, String instagram, String linkedin,
            ObjetivoDTO objetivo, PrecioDTO precio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
        this.videoUrl = videoUrl;
        this.especialidad = especialidad;
        this.descripcion = descripcion;
        this.whatsapp = whatsapp;
        this.facebook = facebook;
        this.instagram = instagram;
        this.linkedin = linkedin;
        this.objetivo = objetivo;
        this.precio = precio;
    }

    
}

