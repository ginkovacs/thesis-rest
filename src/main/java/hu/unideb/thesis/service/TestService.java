package hu.unideb.thesis.service;

import hu.unideb.thesis.models.Course;
import hu.unideb.thesis.models.Test;
import hu.unideb.thesis.models.requests.QuestionRequest;
import hu.unideb.thesis.models.requests.TestRequest;
import hu.unideb.thesis.repository.CourseRepository;
import hu.unideb.thesis.repository.TestRepository;
import hu.unideb.thesis.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Test addTest(String testName, List<QuestionRequest> questions, Integer courseId) {
        Course course = courseRepository.getOne(courseId);

        Test test = new Test();

        test.setName(testName);
        test.setQuestions(Converter.requestToQuestionList(questions, test));
        test.setCourse(course);

        testRepository.save(test);

        return test;
    }

    public void deleteTest(Integer testId) {
        testRepository.deleteById(testId);
    }

    public void updateTest(Integer testId, TestRequest toTest) {
        Test fromTest = testRepository.getOne(testId);

        if (toTest.getName() != null) {
            fromTest.setName(toTest.getName());
        }

        if (toTest.getQuestions() != null) {
            fromTest.setQuestions(Converter.requestToQuestionList(toTest.getQuestions(), fromTest));
        }

        testRepository.save(fromTest);
    }

    public Test findTest(Integer testId) {
        return testRepository.findById(testId)
                .orElseThrow(() -> new RuntimeException("No test found"));
    }

    public List<Test> findAll(Integer courseId) {
        Optional<List<Test>> dolog = testRepository.findAllByCourseId(courseId);

        return dolog.orElseGet(ArrayList::new);
    }
}
