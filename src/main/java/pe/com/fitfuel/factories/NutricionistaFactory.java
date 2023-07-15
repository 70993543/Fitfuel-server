package pe.com.fitfuel.factories;

import pe.com.fitfuel.dto.NutricionistaDTO;
import pe.com.fitfuel.dto.ObjetivoDTO;
import pe.com.fitfuel.dto.PrecioDTO;

public interface NutricionistaFactory {
    NutricionistaDTO crearNutricionista(String nombre, String apellido, String imagen, String videoUrl, String especialidad, String descripcion, String whatsapp, String facebook, String instagram, String linkedin, ObjetivoDTO objetivoDTO, PrecioDTO precioDTO);
}

