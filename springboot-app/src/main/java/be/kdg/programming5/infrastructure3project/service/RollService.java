package be.kdg.programming5.infrastructure3project.service;

import be.kdg.programming5.infrastructure3project.domain.Roll;
import be.kdg.programming5.infrastructure3project.repository.RollRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RollService {

    private final RollRepository rollRepository;

    public RollService(RollRepository rollRepository) {
        this.rollRepository = rollRepository;
    }

    public Roll createRoll(int rolledNumber, String name) {
        return rollRepository.save(new Roll(rolledNumber, name, LocalDateTime.now()));
    }

    public List<Roll> getAllRolls() {
        return rollRepository.findAll();
    }
}
