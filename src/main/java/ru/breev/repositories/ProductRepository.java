package ru.breev.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.breev.entities.Product;
import ru.breev.entities.Products;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;
    Product product;
    SessionFactory factory;
    Session session;

    @PostConstruct
    private void init() {
//        products = new ArrayList<>();
//        products.add(new Product(1L,"iPhone", 60.0));
//        products.add(new Product(2L,"Huawei", 25.0));
//        products.add(new Product(3L,"Xiaomi", 15.0));
//        products.add(new Product(4L,"Honor", 20.0));
//        products.add(new Product(5L,"Samsung", 30.0));

        factory = new Configuration()
                .configure("configs/products/hibernate.cfg.xml")
                .buildSessionFactory();

        session = null;
    }

    public List<Product> getAllProducts() {
        session = factory.getCurrentSession();
        session.beginTransaction();
        products = session.createQuery("SELECT * FROM Products products").getResultList();
//        products = session.createQuery("SELECT * FROM Products products").list();
        session.getTransaction().commit();
        return products;
    }

    public Product getProductById(Long id) {
//        for (Product product : products) {
//            if (product.getId()==id) {
//                return product;
//            }
//        }
//        return null;

        session = factory.getCurrentSession();
        session.beginTransaction();
        product = session.get(Product.class, id);
        System.out.println(product);
        session.getTransaction().commit();
        return product;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
