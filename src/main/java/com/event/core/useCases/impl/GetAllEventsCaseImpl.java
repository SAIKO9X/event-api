package com.event.core.useCases.impl;

import com.event.core.entities.Event;
import com.event.core.gateway.EventGateway;
import com.event.core.useCases.GetAllEventsCase;

import java.util.List;

public class GetAllEventsCaseImpl implements GetAllEventsCase {

  private final EventGateway eventGateway;

  public GetAllEventsCaseImpl(EventGateway eventGateway) {
    this.eventGateway = eventGateway;
  }

  @Override
  public List<Event> execute() {
    return eventGateway.getAllEvents();
  }
}
