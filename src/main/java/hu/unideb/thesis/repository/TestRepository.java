package hu.unideb.thesis.repository;

import hu.unideb.thesis.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {
}
