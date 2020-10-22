package br.com.aps_rest_api.handler;

import br.com.aps_rest_api.exception.LoginException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LoginExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handlerLoginException(LoginException e){
        return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
    }

}
