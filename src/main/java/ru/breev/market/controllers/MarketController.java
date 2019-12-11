package ru.breev.market.controllers;

import ru.breev.market.entites.Item;
import ru.breev.market.services.ItemService;
import ru.breev.market.utils.ItemFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.breev.market.utils.ItemSort;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MarketController {
    private ItemService itemService;

    @Autowired
    public MarketController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        int pageIndex = 0;

        if (params.containsKey("p")) {
            pageIndex = Integer.parseInt(params.get("p")) - 1;
        }

        ItemSort itemSort = new ItemSort(params);

        System.out.println(itemSort.getSort());
        Pageable pageRequest = PageRequest.of(pageIndex, 7, itemSort.getSort());

        ItemFilter itemFilter = new ItemFilter(params);

        Page<Item> page = itemService.findAll(itemFilter.getSpec(), pageRequest);
        System.out.println(page.getSort());

        List<String> categories = Arrays.stream(Item.Category.values()).map(Item.Category::name).collect(Collectors.toList());

        model.addAttribute("filterDef", itemFilter.getFilterDefinition());
        model.addAttribute("sortDef", itemSort.getSortDefinition());
        model.addAttribute("categories", categories);
        model.addAttribute("page", page);
        return "index";
    }
}