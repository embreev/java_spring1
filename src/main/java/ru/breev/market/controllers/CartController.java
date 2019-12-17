package ru.breev.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.breev.market.Cart;
import ru.breev.market.services.CategoryService;
import ru.breev.market.services.ItemService;

@Controller
public class CartController {
    private ItemService itemService;

    @Autowired
    private Cart cart;

    @Autowired
    public CartController(ItemService itemService, CategoryService categoryService) {
        this.itemService = itemService;
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("cart", cart.show());
        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addToCart(Model model, @PathVariable Long id) {
        cart.add(id);
        model.addAttribute("cart", cart.show());
        return "cart";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(Model model, @PathVariable Long id) {
        cart.remove(id);
        model.addAttribute("cart", cart.show());
        return "cart";
    }
}