package hu.unideb.thesis.controller;

import hu.unideb.thesis.models.Course;
import hu.unideb.thesis.models.User;
import hu.unideb.thesis.models.requests.CourseRequest;
import hu.unideb.thesis.models.requests.UserRequest;
import hu.unideb.thesis.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody CourseRequest course) {

        Course addedCourse = courseService.addCourse(course);
        return new ResponseEntity<>(addedCourse, HttpStatus.OK);
    }

    @PutMapping("addUserToCourse")
    public ResponseEntity<Void> addUserToCourse(@RequestParam String email, @RequestParam Integer courseId) {
        courseService.addUserToCourse(email, courseId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("deleteCourse")
    public ResponseEntity<Void> deleteCourse(@RequestParam Integer courseId) {
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("updateCourse")
    public ResponseEntity<Void> updateCourse(@RequestParam Integer id,
                                           @RequestBody CourseRequest course) {

        courseService.updateCourse(id, course);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("findCourse")
    public ResponseEntity<Course> findCourse(@RequestParam Integer id) {
        return new ResponseEntity<>(courseService.findCourse(id), HttpStatus.OK);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Course>> findAll(@RequestParam String email) {
        return new ResponseEntity<>(courseService.findAll(email), HttpStatus.OK);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("ne írd át a requestet kézzel, baszd meg" + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
