package com.event.core.useCases;

import com.event.core.entities.Event;

public interface getEventCase {

  Event execute(Long eventId);
}
