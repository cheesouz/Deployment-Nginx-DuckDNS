package be.kdg.programming5.infrastructure3project.controller.api;

import be.kdg.programming5.infrastructure3project.domain.Roll;
import be.kdg.programming5.infrastructure3project.domain.NewRollDTO;
import be.kdg.programming5.infrastructure3project.domain.RollDTO;
import be.kdg.programming5.infrastructure3project.service.GameService;
import be.kdg.programming5.infrastructure3project.service.RollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api")
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private RollService rollService;


    @GetMapping("/roll")
    public Integer rollDice() {
        return gameService.rollDice();
    }

    @PostMapping("/save")
    public ResponseEntity<RollDTO> saveRoll(@RequestBody NewRollDTO newRollDTO) {
        Roll newRoll = rollService.createRoll(newRollDTO.rolledNumber(), newRollDTO.name());
        return new ResponseEntity<>(
                new RollDTO(newRoll.getId(), newRoll.getRolledNumber(), newRoll.getName(), newRoll.getSubmittedAt()),
                CREATED
        );
    }


}
