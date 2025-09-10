package com.event.core.useCases.impl;

import com.event.core.entities.Event;
import com.event.core.exceptions.EventNotFoundException;
import com.event.core.gateway.EventGateway;
import com.event.core.useCases.GetEventCase;

public class GetEventCaseImpl implements GetEventCase {

  private final EventGateway eventGateway;

  public GetEventCaseImpl(EventGateway eventGateway) {
    this.eventGateway = eventGateway;
  }

  @Override
  public Event execute(Long eventId) {
    return eventGateway.getEvent(eventId).orElseThrow(() -> new EventNotFoundException(eventId));
  }
}
