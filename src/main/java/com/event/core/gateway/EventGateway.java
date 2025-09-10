package com.event.core.gateway;

import com.event.core.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventGateway {
  Event createEvent(Event event);

  Optional<Event> getEvent(Long id);

  List<Event> getAllEvents();

  Optional<Event> findByIdentifier(String identifier);

  Event updateEvent(Event event);
}
