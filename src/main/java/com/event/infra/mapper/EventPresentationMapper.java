package com.event.infra.mapper;

import com.event.core.entities.Event;
import com.event.infra.request.CreateEventRequest;
import com.event.infra.request.UpdateEventRequest;
import com.event.infra.response.EventResponse;
import org.springframework.stereotype.Component;

@Component
public class EventPresentationMapper {

  public Event toDomain(CreateEventRequest request, String organizer, String identifier) {
    return Event.create(
      request.name(),
      request.description(),
      request.location(),
      request.capacity(),
      request.start(),
      request.end(),
      organizer,
      identifier,
      request.eventType()
    );
  }

  public Event toDomain(UpdateEventRequest request, Event existingEvent) {
    return existingEvent.update(
      request.name(),
      request.description(),
      request.location(),
      request.capacity(),
      request.start(),
      request.end()
    );
  }

  public EventResponse toResponse(Event event) {
    return new EventResponse(
      event.id(),
      event.name(),
      event.description(),
      event.location(),
      event.organizer(),
      event.identifier(),
      event.capacity(),
      event.start(),
      event.end(),
      event.eventType()
    );
  }
}