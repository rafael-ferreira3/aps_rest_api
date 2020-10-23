package br.com.aps_rest_api.handler;

import br.com.aps_rest_api.exception.UsuarioException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UsuarioExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handlerLoginException(UsuarioException e){
        return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
    }
}
