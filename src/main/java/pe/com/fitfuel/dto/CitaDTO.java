package pe.com.fitfuel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaDTO {
   
    private Long citaId;

    private String fecha;
  
    private String hora;
  
    private Boolean estado;

    private String nota;

    private String celular;

    private NutricionistaDTO nutricionista;
}
