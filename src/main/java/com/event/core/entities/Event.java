package com.event.core.entities;

import com.event.core.enums.EventType;

import java.time.LocalDateTime;

public record Event(
  Long id,
  String name,
  String description,
  String location,
  String organizer,
  String identifier,
  int capacity,
  LocalDateTime start,
  LocalDateTime end,
  EventType eventType
) {

  // Factory Method para CREATE
  public static Event create(
    String name,
    String description,
    String location,
    int capacity,
    LocalDateTime start_time,
    LocalDateTime end_time,
    String organizer,
    String identifier,
    EventType eventType
  ) {
    return new Event(
      null,
      name,
      description,
      location,
      organizer,
      identifier,
      capacity,
      start_time,
      end_time,
      eventType
    );
  }

  // Factory Method para UPDATE
  public Event update(
    String name,
    String description,
    String location,
    int capacity,
    LocalDateTime start,
    LocalDateTime end
  ) {
    return new Event(
      this.id,
      name,
      description,
      location,
      this.organizer,
      this.identifier,
      capacity,
      start,
      end,
      this.eventType
    );
  }
}
