package com.event.infra.response;

import com.event.core.enums.EventType;

import java.time.LocalDateTime;

public record EventResponse(
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
}