package hu.unideb.thesis.controller;

import hu.unideb.thesis.models.Question;
import hu.unideb.thesis.models.requests.QuestionRequest;
import hu.unideb.thesis.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("addQuestion")
    public ResponseEntity<Question> addQuestion(@RequestBody QuestionRequest question) {

        Question addedQuest = questionService.addQuestion(question.getQuestion(),
                question.getAnswers(),
                question.getTestId());
        return new ResponseEntity<>(addedQuest, HttpStatus.OK);
    }

    @DeleteMapping("deleteQuestion")
    public ResponseEntity<Void> deleteQuestion(@RequestParam Integer questionId) {
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("updateQuestion")
    public ResponseEntity<Void> updateQuestion(@RequestParam Integer id,
                                               @RequestBody QuestionRequest question) {

        questionService.updateQuestion(id, question);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("findQuestion")
    public ResponseEntity<Question> findQuestion(@RequestParam Integer id) {
        return new ResponseEntity<>(questionService.findQuestion(id), HttpStatus.OK);
    }

    @GetMapping("findAllQuestion")
    public ResponseEntity<List<Question>> findAllQuestion() {
        return new ResponseEntity<>(questionService.findAllQuestion(), HttpStatus.OK);
    }
}
