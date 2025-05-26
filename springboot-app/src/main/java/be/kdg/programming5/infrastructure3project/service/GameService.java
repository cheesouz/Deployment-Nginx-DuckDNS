package be.kdg.programming5.infrastructure3project.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {
    Random random;

    public GameService() {
        this.random = new Random();
    }

    public int rollDice() {
        return random.nextInt(6) + 1;
    }
}

