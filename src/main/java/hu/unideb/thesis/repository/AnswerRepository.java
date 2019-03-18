package hu.unideb.thesis.repository;

import hu.unideb.thesis.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
