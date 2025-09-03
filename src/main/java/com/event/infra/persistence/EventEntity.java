package com.event.infra.persistence;

import com.event.core.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_event")
public class EventEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  private String location;
  private String organizer;
  private String identifier;
  private int capacity;
  private LocalDateTime start;
  private LocalDateTime end;

  @Enumerated(EnumType.STRING)
  @Column(name = "event_type", length = 50, nullable = false)
  private EventType eventType;
}
