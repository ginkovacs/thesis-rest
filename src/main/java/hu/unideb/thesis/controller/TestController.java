package hu.unideb.thesis.controller;

import hu.unideb.thesis.models.Test;
import hu.unideb.thesis.models.requests.TestRequest;
import hu.unideb.thesis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping("addTest")
    public ResponseEntity<Test> addTest(@RequestBody TestRequest test) {

        Test addedTest = testService.addTest(test.getName(),
                test.getQuestions(),
                test.getCourseId());
        return new ResponseEntity<>(addedTest, HttpStatus.OK);
    }

    @DeleteMapping("deleteTest")
    public ResponseEntity<Void> deleteTest(@RequestParam Integer testId) {
        testService.deleteTest(testId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("updateTest")
    public ResponseEntity<Void> updateTest(@RequestParam Integer id,
                                           @RequestBody TestRequest test) {

        testService.updateTest(id, test);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("findTest")
    public ResponseEntity<Test> findTest(@RequestParam Integer id) {
        return new ResponseEntity<>(testService.findTest(id), HttpStatus.OK);
    }

    @GetMapping("findAllTest")
    public ResponseEntity<List<Test>> findAllTest() {
        return new ResponseEntity<>(testService.findAllTest(), HttpStatus.OK);
    }
}
