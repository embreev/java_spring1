package ru.breev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.breev.entities.Category;
import ru.breev.entities.Product;
import ru.breev.services.ProductService;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
public class FormsController {

    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/add_product")
    public String showAddNewProductForm() {
        return "add_new_product";
    }

    @RequestMapping(path = "/add_new_product_processing", method = RequestMethod.GET)
    public String addProductProcessForm(Model model, @RequestParam String title, @RequestParam Integer price, @RequestParam Integer category_id) {
//        Product product = new Product(title, price, productService.getCategoryById(category_id));
        Product product = new Product(title, price, category_id);
        productService.addProduct(product);
        model.addAttribute("product", product);
        return "product";
    }

//    @RequestMapping("/show_simple_form")
//    public String showSimpleForm() {
//        return "simple_form";
//    }
//
//    @RequestMapping(path = "/simple_form_processing", method = RequestMethod.GET)
//    public String simpleProcessForm() {
//        return "simple_form_result";
//    }
//
//    @RequestMapping("/show_mod_form")
//    public String showModForm() {
//        return "mod_form";
//    }
//
//    @RequestMapping(path = "/mod_form_processing", method = RequestMethod.GET)
//    public String modProcessForm(@RequestParam("studentName") String studentName, Model model) {
//        studentName = "Modified: " + studentName;
//        model.addAttribute("studentName", studentName);
//        return "mod_form_result";
//    }
}
