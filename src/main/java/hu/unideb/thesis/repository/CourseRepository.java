package hu.unideb.thesis.repository;

import hu.unideb.thesis.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Optional<List<Course>> findAllByUserEmail(String email);
}
