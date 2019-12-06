package ru.breev.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.breev.data.entities.Product;
import ru.breev.data.services.CategoryService;
import ru.breev.data.services.ProductService;

@Controller
public class FormsController {

    ProductService productService;
    CategoryService categoryService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/add_product")
    public String showAddNewProductForm() {
        return "add_new_product";
    }

    @RequestMapping(path = "/add_new_product_processing", method = RequestMethod.GET)
    public String addProductProcessForm(Model model, @RequestParam String title, @RequestParam Integer price, @RequestParam Long category_id) {
        Product product = new Product(title, price, categoryService.getCategoryById(category_id));
        productService.addProduct(product);
        model.addAttribute("product", product);
        return "product";
    }
}
