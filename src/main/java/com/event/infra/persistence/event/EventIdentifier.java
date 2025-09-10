package com.event.infra.persistence.event;

import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.Random;

@Service
public class EventIdentifier {

  private final Random random = new Random();

  public String generateIdentifier(String eventName) {
    String slug = createSlug(eventName);
    String uniqueSuffix = String.valueOf(random.nextInt(10000));
    return slug + "-" + uniqueSuffix;
  }

  public String getCurrentOrganizer() {
    return "admin";
  }

  private String createSlug(String input) {
    if (input == null || input.trim().isEmpty()) {
      return "evento";
    }

    String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
    String withoutAccents = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

    return withoutAccents
      .toLowerCase()
      .trim()
      .replaceAll("\\s+", "-") // Espaços -> hífens
      .replaceAll("[^a-z0-9-]", "") // Remove caracteres especiais
      .replaceAll("-+", "-") // Remove hífens duplicados
      .replaceAll("^-|-$", ""); // Remove hífens do início/fim
  }
}