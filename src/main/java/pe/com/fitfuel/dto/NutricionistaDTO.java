package pe.com.fitfuel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NutricionistaDTO {
    private Long nutricionista_id;
    private String nombre;
    private String apellido;
    private String imagen;
    private String videoUrl;
    private String especialidad;
    private String descripcion;
    private ObjetivoDTO objetivo;
    private PrecioDTO precio;
}

