package com.event.infra.controllers;

import com.event.core.entities.Event;
import com.event.core.useCases.CreateEventCase;
import com.event.core.useCases.GetAllEventsCase;
import com.event.core.useCases.GetEventCase;
import com.event.core.useCases.UpdateEventCase;
import com.event.infra.mapper.EventPresentationMapper;
import com.event.infra.persistence.event.EventIdentifier;
import com.event.infra.request.CreateEventRequest;
import com.event.infra.request.UpdateEventRequest;
import com.event.infra.response.EventResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {

  private final CreateEventCase createEventCase;
  private final GetEventCase getEventCase;
  private final GetAllEventsCase getAllEvents;
  private final UpdateEventCase updateEventCase;
  private final EventPresentationMapper mapper;
  private final EventIdentifier identifier;

  @PostMapping
  public ResponseEntity<EventResponse> createEvent(@RequestBody @Valid CreateEventRequest request) {
    String organizer = identifier.getCurrentOrganizer();
    String eventIdentifier = identifier.generateIdentifier(request.name());

    Event domainEvent = mapper.toDomain(request, organizer, eventIdentifier);
    Event createdEvent = createEventCase.execute(domainEvent);
    EventResponse response = mapper.toResponse(createdEvent);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<EventResponse> getEvent(@PathVariable Long id) {
    Event event = getEventCase.execute(id);
    EventResponse response = mapper.toResponse(event);

    return ResponseEntity.ok(response);
  }

  @GetMapping
  public ResponseEntity<List<EventResponse>> getAllEvents() {
    List<Event> events = getAllEvents.execute();
    List<EventResponse> responses = events.stream()
      .map(mapper::toResponse)
      .toList();

    return ResponseEntity.ok(responses);
  }

  @PutMapping("/{id}")
  public ResponseEntity<EventResponse> updateEvent(@PathVariable Long id, @RequestBody @Valid UpdateEventRequest request) {
    Event eventWithNewData = mapper.toDomain(request, getEventCase.execute(id));
    Event updatedEvent = updateEventCase.execute(id, eventWithNewData);
    EventResponse response = mapper.toResponse(updatedEvent);

    return ResponseEntity.ok(response);
  }
}