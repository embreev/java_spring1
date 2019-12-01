package ru.breev.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.breev.entities.Products;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Products> products;
    Products product;
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

    @PreDestroy
    private void destroy() {
        factory.close();
    }

    public List<Products> getAllProducts() {
        session = factory.getCurrentSession();
        session.beginTransaction();
        products = session.createQuery("SELECT products FROM Products products").getResultList();
//        products = session.createQuery("SELECT * FROM Products products").list();
        session.getTransaction().commit();
        return products;
    }

    public Products getProductById(Long id) {
//        for (Product product : products) {
//            if (product.getId()==id) {
//                return product;
//            }
//        }
//        return null;

        session = factory.getCurrentSession();
        session.beginTransaction();
        product = session.get(Products.class, id);
        System.out.println(product);
        session.getTransaction().commit();
        return product;
    }

    public void addProduct(Products product) {
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }
}
