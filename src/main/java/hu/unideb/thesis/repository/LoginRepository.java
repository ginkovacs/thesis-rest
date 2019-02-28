package hu.unideb.thesis.repository;

import hu.unideb.thesis.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}