package hu.unideb.thesis.controller;

import hu.unideb.thesis.models.Achievement;
import hu.unideb.thesis.models.requests.AchievementRequest;
import hu.unideb.thesis.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("achievements")
public class AchievementController {
    @Autowired
    private AchievementService achievementService;

    @PostMapping("addAchievement")
    public ResponseEntity<Achievement> addAchievement(@RequestBody AchievementRequest achievementRequest) {

        Achievement achievement = achievementService.addAchievement(achievementRequest);
        return new ResponseEntity<>(achievement, HttpStatus.OK);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Achievement>> findAll() {
        return new ResponseEntity<>(achievementService.findAll(), HttpStatus.OK);
    }
}
