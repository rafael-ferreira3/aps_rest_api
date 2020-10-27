package br.com.aps_rest_api.service.handler;

import br.com.aps_rest_api.service.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handlerDefaultClienteException(ServiceException e){
        return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
    }

}
