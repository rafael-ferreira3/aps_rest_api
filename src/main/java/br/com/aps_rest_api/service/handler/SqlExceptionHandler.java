package br.com.aps_rest_api.service.handler;

import br.com.aps_rest_api.service.helpers.ConstraintExceptionMessages;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SqlExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handlerDefaultConstraintException(ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ConstraintExceptionMessages.getConstraintExceptionMessage(e.getConstraintName()));
    }

}
