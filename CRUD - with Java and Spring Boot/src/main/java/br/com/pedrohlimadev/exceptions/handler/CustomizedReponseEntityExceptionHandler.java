package br.com.pedrohlimadev.exceptions.handler;

import br.com.pedrohlimadev.exceptions.ExcepetionsResponse;
import br.com.pedrohlimadev.exceptions.InvalidJwtAuthenticationException;
import br.com.pedrohlimadev.exceptions.RequiredObjectIsNullException;
import br.com.pedrohlimadev.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedReponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExcepetionsResponse> handleAllExceptions(Exception ex, WebRequest request) {
        ExcepetionsResponse excepetionsResponse = new ExcepetionsResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(excepetionsResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExcepetionsResponse> handleNotFoundExceptions(Exception ex, WebRequest request) {
        ExcepetionsResponse excepetionsResponse = new ExcepetionsResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(excepetionsResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RequiredObjectIsNullException.class)
    public final ResponseEntity<ExcepetionsResponse> handleBadRequestExceptions(Exception ex, WebRequest request) {
        ExcepetionsResponse excepetionsResponse = new ExcepetionsResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(excepetionsResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    public final ResponseEntity<ExcepetionsResponse> handleInvalidJwtAuthenticationExceptions(Exception ex, WebRequest request) {
        ExcepetionsResponse excepetionsResponse = new ExcepetionsResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(excepetionsResponse, HttpStatus.FORBIDDEN);
    }

}