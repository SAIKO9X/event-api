package com.event.core.useCases.impl;

import com.event.core.entities.Event;
import com.event.core.exceptions.EventAlreadyExistsException;
import com.event.core.gateway.EventGateway;
import com.event.core.useCases.CreateEventCase;

public class CreateEventCaseImpl implements CreateEventCase {

  private final EventGateway eventGateway;

  public CreateEventCaseImpl(EventGateway eventGateway) {
    this.eventGateway = eventGateway;
  }

  @Override
  public Event execute(Event event) {
    this.eventGateway.findByIdentifier(
      event.identifier()).ifPresent(existingEvent -> {
      throw new EventAlreadyExistsException("Já existe um evento com o identificador: " + event.identifier() + ", no evento: " + existingEvent.name());
    });

    return eventGateway.createEvent(event);
  }
}
