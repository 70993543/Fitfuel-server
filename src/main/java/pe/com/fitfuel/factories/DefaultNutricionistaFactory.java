package pe.com.fitfuel.factories;

import pe.com.fitfuel.dto.NutricionistaDTO;
import pe.com.fitfuel.dto.ObjetivoDTO;
import pe.com.fitfuel.dto.PrecioDTO;

public class DefaultNutricionistaFactory implements NutricionistaFactory {

    @Override
    public NutricionistaDTO crearNutricionista(String nombre, String apellido, String imagen, String videoUrl, String especialidad, String descripcion, String whatsapp, String facebook, String instagram, String linkedin, ObjetivoDTO objetivoDTO, PrecioDTO precioDTO) {
        return new NutricionistaDTO(nombre, apellido, imagen, videoUrl, especialidad, descripcion, whatsapp, facebook, instagram, linkedin, objetivoDTO, precioDTO);
    }
}
