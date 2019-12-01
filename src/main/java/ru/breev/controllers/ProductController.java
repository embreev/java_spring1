package ru.breev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.breev.entities.Product;
import ru.breev.entities.Products;
import ru.breev.services.ProductService;

import java.util.Arrays;
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
        List<Products> products = productService.getAllProducts();
        model.addAttribute("all_products", products);
        return "all_products";
    }

    @GetMapping("/product")
    public String showProduct(Model model, @RequestParam(name = "id", required = true) Long id) {
        Products product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

    // http://localhost:8189/app/products/info/1
    @RequestMapping(path = "/info/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Products getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

//    // POST http://localhost:8189/app/students/process_form
//    @PostMapping("/process_form")
//    public String processForm(@ModelAttribute("student") Student student) {
//        return "student_form_result";
//    }

//    // GET http://localhost:8189/app/students/show_form
//    @GetMapping("/show_form")
//    public String showSimpleForm(Model model) {
//        Product student = new Product();
//        model.addAttribute("student", student);
//
//        List<String> programmingLanguagesList = Arrays.asList(new String[]{"C++", "Java", "Python", "PHP", "C#"});
//        model.addAttribute("pLanguages", programmingLanguagesList);
//        return "student_form";
//    }

//    // POST http://localhost:8189/app/students/process_form
//    @PostMapping("/process_form")
//    public String processForm(@ModelAttribute("student") Student student) {
//        return "student_form_result";
//    }
//
//    // http://localhost:8189/app/students/info/1
//    @RequestMapping(path = "/info/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public Student getStudentById(@PathVariable Long id) {
//        return studentsService.findById(id).orElseThrow(() -> new RuntimeException());
//    }
//
//    // http://localhost:8189/app/students/show
//    @RequestMapping(path = "/show", method = RequestMethod.GET)
//    public String showAllStudents(Model model) {
//        List<Student> students = studentsService.getAllStudents();
//        model.addAttribute("students", students);
//        return "all_students";
//    }
}