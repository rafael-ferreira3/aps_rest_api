package br.com.aps_rest_api.service.helpers;

import br.com.aps_rest_api.service.exception.ServiceException;

import java.util.Date;

public class ErrorMessage {

    private Date timestamp;
    private String message;
    private int code;

    public ErrorMessage(String message, int code) {
        this.message = message;
        this.timestamp = new Date();
        this.code = code;
    }

    public ErrorMessage(ServiceException e) {
        this.message = e.getMessage();
        this.timestamp = new Date();
        this.code = e.getHttpStatus().value();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                '}';
    }
}
