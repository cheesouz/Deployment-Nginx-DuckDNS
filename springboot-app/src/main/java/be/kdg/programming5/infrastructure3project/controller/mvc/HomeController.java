package be.kdg.programming5.infrastructure3project.controller.mvc;

import be.kdg.programming5.infrastructure3project.domain.RollDTO;
import be.kdg.programming5.infrastructure3project.service.RollService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    private final RollService rollService;

    public HomeController(RollService rollService) {
        this.rollService = rollService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/history")
    public String history(Model model) {
//        model.addAttribute("rolls", rollService.getAllRolls().stream().map(
//                roll -> new RollDTO(roll.getId(),
//                        roll.getRolledNumber(),
//                        roll.getName(),
//                        roll.getSubmittedAt())
//        ).toList());

        model.addAttribute("rolls", rollService.getAllRolls());
        return "history";
    }
}
