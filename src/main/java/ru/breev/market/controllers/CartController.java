package ru.breev.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.breev.market.entites.Item;
import ru.breev.market.services.CategoryService;
import ru.breev.market.services.ItemService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    private ItemService itemService;
    private List<Item> cart = new ArrayList<>();

    @Autowired
    public CartController(ItemService itemService, CategoryService categoryService) {
        this.itemService = itemService;
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addToCart(Model model, @PathVariable Long id) {
        cart.add(itemService.findById(id));
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(Model model, @PathVariable Long id) {
        cart.remove(itemService.findById(id));
        model.addAttribute("cart", cart);
        return "cart";
    }
}