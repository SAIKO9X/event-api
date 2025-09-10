package com.event.core.exceptions;

public class EventAlreadyExistsException extends RuntimeException {
  public EventAlreadyExistsException(String message) {
    super(message);
  }
}