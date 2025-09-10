package com.event.core.useCases;

import com.event.core.entities.Event;

public interface UpdateEventCase {

  Event execute(Long id, Event event);
}
