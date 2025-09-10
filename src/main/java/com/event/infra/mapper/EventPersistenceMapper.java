package com.event.infra.mapper;

import com.event.core.entities.Event;
import com.event.infra.persistence.event.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventPersistenceMapper {

  public EventEntity toEntity(Event event) {
    return EventEntity.builder()
      .id(event.id())
      .name(event.name())
      .description(event.description())
      .location(event.location())
      .organizer(event.organizer())
      .identifier(event.identifier())
      .capacity(event.capacity())
      .start(event.start())
      .end(event.end())
      .eventType(event.eventType())
      .build();
  }

  public Event toDomain(EventEntity entity) {
    return new Event(
      entity.getId(),
      entity.getName(),
      entity.getDescription(),
      entity.getLocation(),
      entity.getOrganizer(),
      entity.getIdentifier(),
      entity.getCapacity(),
      entity.getStart(),
      entity.getEnd(),
      entity.getEventType()
    );
  }
}