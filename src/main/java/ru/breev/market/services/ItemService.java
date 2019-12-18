package ru.breev.market.services;

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

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(Long id) {
        return itemRepository.findById(id).get();
    }

    public void addItem(Item item) {
        itemRepository.saveAndFlush(item);
    }

    public void updateItem(Long id, Item item) {
        itemRepository.findById(id).map(i -> {
            i.setCategory(item.getCategory());
            i.setTitle(item.getTitle());
            i.setDescription(item.getDescription());
            i.setPrice(item.getPrice());
            return itemRepository.saveAndFlush(i);
        });
    }

    public void delItem(Long id) {
        itemRepository.delete(itemRepository.getOne(id));
    }
}
