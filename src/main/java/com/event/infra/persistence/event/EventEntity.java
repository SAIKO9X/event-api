package com.event.infra.persistence.event;

import com.event.core.enums.EventType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
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

  @Column(name = "start_time")
  private LocalDateTime start;

  @Column(name = "end_time")
  private LocalDateTime end;

  @Enumerated(EnumType.STRING)
  @Column(name = "event_type", length = 50, nullable = false)
  private EventType eventType;
}
