package com.event.core.useCases;

import com.event.core.entities.Event;

public interface GetEventCase {

  Event execute(Long id);
}