package com.event.infra.config;

import com.event.core.gateway.EventGateway;
import com.event.core.useCases.CreateEventCase;
import com.event.core.useCases.GetAllEventsCase;
import com.event.core.useCases.GetEventCase;
import com.event.core.useCases.UpdateEventCase;
import com.event.core.useCases.impl.CreateEventCaseImpl;
import com.event.core.useCases.impl.GetAllEventsCaseImpl;
import com.event.core.useCases.impl.GetEventCaseImpl;
import com.event.core.useCases.impl.UpdateEventCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

  @Bean
  public CreateEventCase createEvent(EventGateway gateway) {
    return new CreateEventCaseImpl(gateway);
  }

  @Bean
  public GetEventCase getEventCase(EventGateway eventGateway) {
    return new GetEventCaseImpl(eventGateway);
  }

  @Bean
  public GetAllEventsCase getAllEventsCase(EventGateway eventGateway) {
    return new GetAllEventsCaseImpl(eventGateway);
  }

  @Bean
  public UpdateEventCase updateEventCase(EventGateway eventGateway) {
    return new UpdateEventCaseImpl(eventGateway);
  }
}
