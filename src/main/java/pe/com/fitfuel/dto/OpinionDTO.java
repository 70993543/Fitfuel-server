package pe.com.fitfuel.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpinionDTO {
   
    private Long opinionId;
   
    private String comentario;
  
    private Integer calificacion;

    private Date fechaHora;

    private NutricionistaDTO nutricionista;
}
