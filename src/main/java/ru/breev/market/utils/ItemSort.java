package ru.breev.market.utils;

import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;
import ru.breev.market.entites.Item;

import java.util.Map;

@Getter
public class ItemSort {
    private StringBuilder sortDefinition;

    public ItemSort(Map<String, String> map) {
        this.sortDefinition = new StringBuilder();
        if (map.containsKey("sort_by_id") && !map.get("sort_by_id").isEmpty()) {
        }
        if (map.containsKey("sort_by_title") && !map.get("sort_by_title").isEmpty()) {
        }
        if (map.containsKey("sort_by_price") && !map.get("sort_by_price").isEmpty()) {
        }
    }

    public Object getSortDefinition() {
        return sortDefinition;
    }
}
