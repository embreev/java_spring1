package ru.breev.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.breev.market.common.Product;
import ru.breev.market.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public void setPr(ProductRepository pr) {
        this.productRepository = pr;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProduct();
    }

    public Product getProductById (Long id) {
        return productRepository.getProductById(id);
    }
}
