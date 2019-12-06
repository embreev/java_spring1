package ru.breev.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.breev.data.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
