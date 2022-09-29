package br.com.pedrohlimadev.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceCustomizeException extends RuntimeException {

    public ResourceCustomizeException(String ex) {
        super(ex);
    }
}