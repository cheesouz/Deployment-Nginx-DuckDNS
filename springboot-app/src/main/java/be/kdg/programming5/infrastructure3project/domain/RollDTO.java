package be.kdg.programming5.infrastructure3project.domain;

import java.time.LocalDateTime;

public record RollDTO(
        long id,
        int rolledNumber,
        String name,
        LocalDateTime submittedAt) {
}
