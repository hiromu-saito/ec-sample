package com.example.eccommon;

import com.example.eccommon.exception.AuthException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<Object> handlerAuthException (Exception ex){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        return  new ResponseEntity<>(ex.getMessage(),headers,status);
    }
}