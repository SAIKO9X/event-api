package com.event.infra.gateway;

import com.event.core.entities.Event;
import com.event.core.gateway.EventGateway;
import com.event.infra.mapper.EventPersistenceMapper;
import com.event.infra.persistence.event.EventEntity;
import com.event.infra.persistence.event.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {

  private final EventRepository eventRepository;
  private final EventPersistenceMapper mapper;

  @Override
  public Event createEvent(Event event) {
    EventEntity entity = mapper.toEntity(event);
    EventEntity savedEntity = eventRepository.save(entity);
    return mapper.toDomain(savedEntity);
  }

  @Override
  public Optional<Event> getEvent(Long id) {
    return eventRepository.findById(id).map(mapper::toDomain);
  }

  @Override
  public List<Event> getAllEvents() {
    return eventRepository.findAll()
      .stream()
      .map(mapper::toDomain)
      .toList();
  }

  @Override
  public Optional<Event> findByIdentifier(String identifier) {
    Optional<EventEntity> entityOptional = eventRepository.findByIdentifier(identifier);
    return entityOptional.map(mapper::toDomain);
  }

  @Override
  public Event updateEvent(Event event) {
    EventEntity entity = mapper.toEntity(event);
    EventEntity savedEntity = eventRepository.save(entity);
    return mapper.toDomain(savedEntity);
  }
}
