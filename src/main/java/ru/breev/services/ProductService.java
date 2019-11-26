package ru.breev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.breev.entities.Product;
import ru.breev.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProduct();
    }

    public Product getProductById (Long id) {
        return productRepository.getProductById(id);
    }
}
