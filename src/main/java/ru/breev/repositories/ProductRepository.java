package ru.breev.repositories;

import org.springframework.stereotype.Repository;
import ru.breev.entities.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    private void init() {
//        products = new ArrayList<>();
//        products.add(new Product(1L,"iPhone", 60.0));
//        products.add(new Product(2L,"Huawei", 25.0));
//        products.add(new Product(3L,"Xiaomi", 15.0));
//        products.add(new Product(4L,"Honor", 20.0));
//        products.add(new Product(5L,"Samsung", 30.0));
    }

    public List<Product> getAllProduct() {
        return products;
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId()==id) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
