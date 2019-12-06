package ru.breev.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.breev.data.entities.Product;
import ru.breev.data.repositories.ProductRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {
    List<Product> tmpListProducts;
    ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById (Long id) {
        return productRepository.findById(id).get();
    }

    public void addProduct(Product product) {
        productRepository.saveAndFlush(product);
    }

    public List<Product> getProductMinPrice() {
        return productRepository.findAll();
    }

    public List<Product> getProductMaxPrice() {
        return productRepository.findAll();
    }

    public List<Product> getMinMaxProducts() {
        return productRepository.findAll();
    }
}
