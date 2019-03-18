package hu.unideb.thesis.controller;

import hu.unideb.thesis.models.Answer;
import hu.unideb.thesis.models.requests.AnswerRequest;
import hu.unideb.thesis.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping("addAnswer")
    public ResponseEntity<Answer> addAnswer(@RequestParam AnswerRequest answer, @RequestParam Integer questionId) {

        Answer addedQuest = answerService.addAnswer(answer, questionId);

        return new ResponseEntity<>(addedQuest, HttpStatus.OK);
    }

    @DeleteMapping("deleteAnswer")
    public ResponseEntity<Void> deleteAnswer(@RequestParam Integer answerId) {
        answerService.deleteAnswer(answerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("updateAnswer")
    public ResponseEntity<Void> updateAnswer(@RequestParam Integer id,
                                             @RequestParam AnswerRequest answer) {

        answerService.updateAnswer(id, answer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("findAnswer")
    public ResponseEntity<Answer> findAnswer(@RequestParam Integer id) {
        return new ResponseEntity<>(answerService.findAnswer(id), HttpStatus.OK);
    }

    @GetMapping("findAllAnswer")
    public ResponseEntity<List<Answer>> findAllAnswer() {
        return new ResponseEntity<>(answerService.findAllAnswer(), HttpStatus.OK);
    }
}
