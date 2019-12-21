package ru.breev.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.breev.market.entites.Item;
import ru.breev.market.repositories.ItemRepository;
import ru.breev.market.services.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ApiController {
    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    @ResponseBody
    public List<Item> getItems() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Item getItemById(@PathVariable Long id) {
        return itemService.findById(id);
    }

    @PostMapping
    public Item addItem(@RequestBody Item item) {
        itemService.addItem(item);
        return item;
    }

    @DeleteMapping("/{id}")
    public void delItem(@PathVariable Long id) {
        itemService.delItem(id);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable Long id, @RequestBody Item item) {
        itemService.updateItem(id, item);
    }
}
