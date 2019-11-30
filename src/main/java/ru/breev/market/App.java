package ru.breev.market;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.breev.market.common.Cart;
import ru.breev.market.common.Product;
import ru.breev.market.config.AppConfig;
import ru.breev.market.services.ProductService;


public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService ps = context.getBean("productService", ProductService.class);
        Cart userCart = context.getBean("cart", Cart.class);
        Product userProduct = ps.getProductById(1L);
        userCart.addToCart(userProduct);
        userCart.printAllProductsInCart();

        context.close();
    }
}
