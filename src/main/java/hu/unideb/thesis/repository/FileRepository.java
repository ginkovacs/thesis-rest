package hu.unideb.thesis.repository;

import hu.unideb.thesis.models.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<Files, Integer> {
    Optional<List<Files>> findAllByCourseId(Integer id);
}
