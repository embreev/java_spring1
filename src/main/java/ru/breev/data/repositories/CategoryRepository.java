package ru.breev.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.breev.data.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
