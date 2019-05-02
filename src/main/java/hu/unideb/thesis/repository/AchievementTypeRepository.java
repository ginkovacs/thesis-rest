package hu.unideb.thesis.repository;

import hu.unideb.thesis.models.AchievementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementTypeRepository extends JpaRepository<AchievementType, Integer> {
}
