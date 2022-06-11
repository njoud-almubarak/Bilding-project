package com.example.building.advice;

import com.example.building.model.Api;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advicecontroller {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Api> handleMethodArgument(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(message,400));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Api> handleDataIntegrity(DataIntegrityViolationException dataIntegrityViolationException){
        String message=dataIntegrityViolationException.getRootCause().getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(message,400));
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Api> handleException(Exception exception){
        System.out.println(exception.getMessage());
        return ResponseEntity.status(500).body(new Api("SERVER ERROR !",500));
    }
}
