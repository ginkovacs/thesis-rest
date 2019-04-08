package hu.unideb.thesis.repository;

import hu.unideb.thesis.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestRepository extends JpaRepository<Test, Integer> {
    Optional<List<Test>> findAllByCourseId(Integer id);
}
