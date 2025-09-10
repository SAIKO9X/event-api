package com.event.core.useCases;

import com.event.core.entities.Event;

import java.util.List;

public interface GetAllEventsCase {

  List<Event> execute();
}
