package com.example.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by 433132 on 7/13/2016.
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /*@ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println(ex.getMessage());
        return handleExceptionInternal(ex, ex.getMessage()
                ,null, HttpStatus.ACCEPTED,request);

    }*/

    @Override
    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");
        System.out.println();
        ex.printStackTrace();
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }
}
