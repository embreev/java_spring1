package ru.breev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.breev.entities.Product;
import ru.breev.entities.Products;
import ru.breev.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Products> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Products getProductById (Long id) {
        return productRepository.getProductById(id);
    }

    public void addProduct(Products product) {
        productRepository.addProduct(product);
    }
}
