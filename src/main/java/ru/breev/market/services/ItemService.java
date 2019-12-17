package ru.breev.market.services;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ru.breev.market.entites.Item;
import ru.breev.market.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Page<Item> findAll(Specification<Item> spec, Pageable pageable) {
        return itemRepository.findAll(spec, pageable);
    }

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public Item findById(Long id) {
        return itemRepository.getOne(id);
    }

    public void addItem(Item item) {
        itemRepository.saveAndFlush(item);
    }

    public void updateItem(Item item) {
    }

    public void delItem(Item item) {
        itemRepository.delete(item);
    }
}
