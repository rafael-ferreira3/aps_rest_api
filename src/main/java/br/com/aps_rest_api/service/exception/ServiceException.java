package br.com.aps_rest_api.service.exception;

import org.springframework.http.HttpStatus;

public class ServiceException extends RuntimeException{

    HttpStatus httpStatus;
    String message;

    public ServiceException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "httpStatus=" + httpStatus +
                ", message='" + message + '\'' +
                '}';
    }
}