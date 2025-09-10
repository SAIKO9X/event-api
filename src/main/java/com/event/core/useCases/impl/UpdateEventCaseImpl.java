package com.event.core.useCases.impl;

import com.event.core.entities.Event;
import com.event.core.exceptions.EventNotFoundException;
import com.event.core.gateway.EventGateway;
import com.event.core.useCases.UpdateEventCase;

public class UpdateEventCaseImpl implements UpdateEventCase {

  private final EventGateway eventGateway;

  public UpdateEventCaseImpl(EventGateway eventGateway) {
    this.eventGateway = eventGateway;
  }

  @Override
  public Event execute(Long id, Event event) {
    Event existingEvent = eventGateway.getEvent(id)
      .orElseThrow(() -> new EventNotFoundException(id));

    Event updatedEvent = existingEvent.update(
      event.name(),
      event.description(),
      event.location(),
      event.capacity(),
      event.start(),
      event.end()
    );

    return eventGateway.updateEvent(updatedEvent);
  }
}
