package ru.breev.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.breev.data.entities.Product;
import ru.breev.data.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {
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

    public List<Product> getProductsMinPrice() {
        return productRepository.findAll().stream().sorted(Comparator.comparingInt(Product::getPrice)).collect(Collectors.toList());
    }

    public List<Product> getProductsMaxPrice() {
        return productRepository.findAll().stream().sorted(Comparator.comparingInt(Product::getPrice).reversed()).collect(Collectors.toList());
    }

    public List<Product> getProductsMinMaxPrice() {
        List<Product> tmpListProducts = Stream.of(getProductsMinPrice().get(0), getProductsMaxPrice().get(0)).collect(Collectors.toList());
        return tmpListProducts;
    }
}
