package hu.unideb.thesis.repository;

import hu.unideb.thesis.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
