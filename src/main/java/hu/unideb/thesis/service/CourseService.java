package hu.unideb.thesis.service;

import hu.unideb.thesis.models.Course;
import hu.unideb.thesis.models.User;
import hu.unideb.thesis.models.requests.CourseRequest;
import hu.unideb.thesis.repository.CourseRepository;
import hu.unideb.thesis.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    //static Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    public Course addCourse(CourseRequest request) {
        User user = userRepository.findByEmail(request.getUserEmail()).orElseThrow(() -> new RuntimeException("Email not found."));

        Course course = new Course();

        course.setName(request.getCourseName());
        course.setDescription(request.getDescription());
        course.setUser(user);

        courseRepository.save(course);

        return course;
    }

    public void deleteCourse(Integer courseId) {
        courseRepository.deleteById(courseId);
    }

    public void updateCourse(Integer courseId, CourseRequest toCourse) {
        Course fromCourse = courseRepository.getOne(courseId);

        if (toCourse.getCourseName() != null) {
            fromCourse.setName(toCourse.getCourseName());
        }

        if (toCourse.getDescription() != null) {
            fromCourse.setDescription(toCourse.getDescription());
        }

        courseRepository.save(fromCourse);
    }

    public Course findCourse(Integer courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("No course found"));
    }

    public List<Course> findAll(String userEmail) {
        Optional<List<Course>> dolog = courseRepository.findAllByUserEmail(userEmail);

        return dolog.orElseGet(ArrayList::new);
    }
}
