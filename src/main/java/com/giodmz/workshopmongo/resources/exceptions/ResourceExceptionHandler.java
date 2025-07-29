package com.giodmz.workshopmongo.resources.exceptions;

import com.sun.jdi.ObjectCollectedException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// classe responsável por tratas possíveis erros nas requisições
@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectCollectedException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectCollectedException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(),
                status.value(),
                "Not found", e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
