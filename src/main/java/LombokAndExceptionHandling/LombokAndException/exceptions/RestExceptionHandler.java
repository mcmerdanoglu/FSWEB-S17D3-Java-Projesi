package LombokAndExceptionHandling.LombokAndException.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //Global düzeydeki hataları yakalaması için konulur
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<AnimalErrorResponse> handleException(AnimalException exception){
        AnimalErrorResponse response = new AnimalErrorResponse(exception.getStatus().value(),
                exception.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(response, exception.getStatus());
    }

    @ExceptionHandler //En global düzeyde hata yönetimi. Exception sınıfı en üst hata sınıfıdır...
    public ResponseEntity<AnimalErrorResponse> handleException(Exception exception){
        AnimalErrorResponse response = new AnimalErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
