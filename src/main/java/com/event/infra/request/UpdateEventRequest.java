package com.event.infra.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record UpdateEventRequest(
  @NotBlank(message = "O nome do evento não pode ser vazio.")
  String name,

  String description,

  @NotBlank(message = "A localização não pode ser vazia.")
  String location,

  @Positive(message = "A capacidade deve ser um número positivo.")
  int capacity,

  @NotNull(message = "A data de início é obrigatória.")
  @Future(message = "A data de início deve ser no futuro.")
  LocalDateTime start,

  @NotNull(message = "A data de fim é obrigatória.")
  @Future(message = "A data de fim deve ser no futuro.")
  LocalDateTime end
  ) {
}