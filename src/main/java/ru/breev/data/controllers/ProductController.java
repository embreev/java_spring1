package ru.breev.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.breev.data.entities.Product;
import ru.breev.data.services.ProductService;

import java.util.List;


// http://localhost:8189/app/students/...
@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String showAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/min")
    public String showProductMinPrice(Model model) {
        List<Product> products = productService.getProductsMinPrice();
        model.addAttribute("products", products.get(0));
        return "products";
    }

    @GetMapping("/max")
    public String showProductMaxPrice(Model model) {
        List<Product> products = productService.getProductsMaxPrice();
        model.addAttribute("products", products.get(0));
        return "products";
    }

    @GetMapping("/minmax")
    public String showProductMinMaxPrice(Model model) {
        List<Product> products = productService.getProductsMinMaxPrice();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/product")
    public String showProduct(Model model, @RequestParam(name = "id", required = true) Long id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

    // http://localhost:8189/app/products/info/1
    @RequestMapping(path = "/info/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

}
