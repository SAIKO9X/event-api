package com.event.infra.exceptions;

import com.event.core.exceptions.EventAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(EventAlreadyExistsException.class)
  public ResponseEntity<Map<String, String>> handleEventAlreadyExists(EventAlreadyExistsException ex) {
    Map<String, String> errorResponse = Map.of(
      "error", "Conflict",
      "message", ex.getMessage()
    );

    return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
  }
}