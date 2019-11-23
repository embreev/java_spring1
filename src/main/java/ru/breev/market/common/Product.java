package ru.breev.market.common;

public class Product {

    private Long id;
    private String title;
    private Float cost;

    public Product(Long id, String title, Float price) {
        this.id = id;
        this.title = title;
        this.cost = price;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Float getCost() {
        return cost;
    }
}
