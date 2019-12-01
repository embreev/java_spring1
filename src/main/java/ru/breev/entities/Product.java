package ru.breev.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;

    @Column(name = "category_id")
    private int category_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }


    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Product() {
    }

    public Product(String title, int price, int category_id) {
        this.title = title;
        this.price = price;
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return String.format("Product [id = %d, title = %s, price = %d, category = %s]", id, title, price, category_id);
    }
}

