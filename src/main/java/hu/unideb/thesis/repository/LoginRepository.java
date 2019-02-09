package hu.unideb.thesis.repository;

import hu.unideb.thesis.models.UserReg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<UserReg, String> { }