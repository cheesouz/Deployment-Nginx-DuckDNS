package be.kdg.programming5.infrastructure3project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Roll {

    @Id
    @GeneratedValue
    private Long id;
    private int rolledNumber;
    private String name;
    private LocalDateTime submittedAt;

    public Roll() {
    }

    public Roll(int rolledNumber, String name, LocalDateTime submittedAt) {
        this.rolledNumber = rolledNumber;
        this.name = name;
        this.submittedAt = submittedAt;
    }

    public Long getId() {
        return id;
    }

    public int getRolledNumber() {
        return rolledNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }
}
