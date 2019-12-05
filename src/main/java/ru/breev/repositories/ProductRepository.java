package ru.breev.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.breev.entities.Category;
import ru.breev.entities.Product;
import ru.breev.services.SessionService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;
    Product product;
    Category category;
    SessionService sessionService;

//    SessionFactory factory;
    Session session;
//
//    @PostConstruct
//    private void init() {
////        products = new ArrayList<>();
////        products.add(new Product(1L,"iPhone", 60.0));
////        products.add(new Product(2L,"Huawei", 25.0));
////        products.add(new Product(3L,"Xiaomi", 15.0));
////        products.add(new Product(4L,"Honor", 20.0));
////        products.add(new Product(5L,"Samsung", 30.0));
//
//        factory = new Configuration()
//                .configure("configs/common/hibernate.cfg.xml")
//                .buildSessionFactory();
//
//        session = null;
//    }

    @Autowired
    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PreDestroy
    private void destroy() {
        sessionService.closeSession();
    }

    public List<Product> getAllProducts() {
        session = sessionService.getCurrentSession();
        session.beginTransaction();
        products = session.createQuery("SELECT products FROM Product products").getResultList();
//        products = session.createQuery("SELECT * FROM Product products").list();
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

        session = sessionService.getCurrentSession();
        session.beginTransaction();
        product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    public void addProduct(Product product) {
        session = sessionService.getCurrentSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }

    public Category getCategoryById(Long id) {
        session = sessionService.getCurrentSession();
        session.beginTransaction();
        category = session.get(Category.class, id);
        session.getTransaction().commit();
        return category;
    }
}
