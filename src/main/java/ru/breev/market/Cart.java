package ru.breev.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.breev.market.entites.Item;
import ru.breev.market.services.ItemService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class Cart {
    private ItemService itemService;
    private List<Item> cart;

    @PostConstruct
    private void init() {
        cart = new ArrayList<>();
    }

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    public List<Item> show() {
        return cart;
    }

    public void add(Long id) {
        if (itemService.findById(id) != null) {
            cart.add(itemService.findById(id));
        } else {
            System.out.println("Товара с таким ID не существует!");
        }
    }

    public void remove(Long id) {
        if (itemService.findById(id) != null) {
            for (Item item : cart) {
                if (itemService.findById(id).equals(item)) {
                    cart.remove(item);
                }
            }
        }
    }

}
