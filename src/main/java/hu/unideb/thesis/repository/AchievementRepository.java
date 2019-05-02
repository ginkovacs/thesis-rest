package hu.unideb.thesis.repository;

import hu.unideb.thesis.models.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Integer> {
    Optional<List<Achievement>> findAllByTestId(Integer testId);
}
