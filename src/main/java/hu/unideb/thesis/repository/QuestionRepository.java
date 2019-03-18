package hu.unideb.thesis.repository;

import hu.unideb.thesis.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
