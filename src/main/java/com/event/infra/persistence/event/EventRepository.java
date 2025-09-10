package com.event.infra.persistence.event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

  Optional<EventEntity> findByIdentifier(String identifier);
}
