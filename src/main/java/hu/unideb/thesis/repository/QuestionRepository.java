package hu.unideb.thesis.repository;

import hu.unideb.thesis.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Optional<List<Question>> findAllByTestId(Integer id);
}
