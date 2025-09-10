package com.event.core.exceptions;

public class EventNotFoundException extends RuntimeException {

  public EventNotFoundException(Long eventId) {
    super("Evento não encontrado com ID: " + eventId);
  }
}