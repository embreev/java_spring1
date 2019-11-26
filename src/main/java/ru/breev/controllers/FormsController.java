package ru.breev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormsController {

    @RequestMapping("/add_product")
    public String showAddNewProductForm() {
        return "add_new_product";
    }

    @RequestMapping(path = "/add_new_product_processing", method = RequestMethod.GET)
    public String addProductProcessForm() {
        return "add_new_product_result";
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
