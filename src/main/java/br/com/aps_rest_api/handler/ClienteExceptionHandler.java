package br.com.aps_rest_api.handler;

import br.com.aps_rest_api.exception.ClienteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClienteExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handlerDefaultClienteException(ClienteException e){
        return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
    }

}
