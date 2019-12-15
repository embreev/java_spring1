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
        if(map.containsKey("sort") && !map.get("sort").isEmpty()) {
            if (map.get("sort").equals("id")) {
                this.sortBy = Sort.by(Sort.Direction.ASC, "id");
                sortDefinition.append("&sort=id");
            }
            if (map.get("sort").equals("title")) {
                this.sortBy = Sort.by(Sort.Direction.ASC, "title");
                sortDefinition.append("&sort=title");
            }
            if (map.get("sort").equals("cat")) {
                this.sortBy = Sort.by(Sort.Direction.ASC, "cat");
                sortDefinition.append("&sort=cat");
            }
            if (map.get("sort").equals("price")) {
                this.sortBy = Sort.by(Sort.Direction.ASC, "price");
                sortDefinition.append("&sort=price");
            }
        } else {
            this.sortBy = Sort.by(Sort.Direction.ASC, "id");
            sortDefinition.append("&sort=id");
        }
    }

    public Sort getSort() {
        return sortBy;
    }

    public String getSortDefinition() {
        return sortDefinition.toString();
    }
}
