package ru.breev.market.common;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Cart {
    Set<Product> cart = new HashSet<Product>();

    private void addToCart(Product product) {
        this.cart.add(product);
    }

    private void printAllProductsInCart() {
        System.out.println(this.cart);
    }
}
