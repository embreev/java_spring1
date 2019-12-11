package ru.breev.market.utils;

import lombok.Getter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
public class ItemSort {
    private StringBuilder sortDefinition;
    private Sort sortBy;

    public ItemSort(Map<String, String> map) {
        this.sortDefinition = new StringBuilder();
        if (map.containsKey("id") && !map.get("id").isEmpty()) {
            sortBy = Sort.by(Sort.Direction.ASC, "id");
            sortDefinition.append("&sort=id");
        }
        if (map.containsKey("title") && !map.get("title").isEmpty()) {
            sortBy = Sort.by(Sort.Direction.ASC, "title");
            sortDefinition.append("&sort=title");
        }
        if (map.containsKey("price") && !map.get("price").isEmpty()) {
            sortBy = Sort.by(Sort.Direction.ASC, "price");
            sortDefinition.append("&sort=price");
        }
    }

    public Sort getSort() {
        return sortBy;
    }

    public String getSortDefinition() {
        return sortDefinition.toString();
    }
}
