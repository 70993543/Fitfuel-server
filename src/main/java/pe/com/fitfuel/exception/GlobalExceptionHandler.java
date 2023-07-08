package pe.com.fitfuel.exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ValidationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e){
    // Personalizar la respuesta de error para la excepcion NotFoundException
        String mensajeError = "El recurso solicitado no fue encontrado";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensajeError);
    }
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(ValidationException e) {
        // Personalizar la respuesta de error para la excepción ValidationException
        String mensajeError = "Error de validación en los datos enviados.";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensajeError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // Personalizar la respuesta de error para otras excepciones no controladas
        String mensajeError = "Ocurrió un error en el servidor.";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
    }
}
