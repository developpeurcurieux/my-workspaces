package com.easysoft.web.controller;

import com.easysoft.entities.Categorie;
import com.easysoft.metier.AdminCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/adminCat")
public class AdminCategorieController {
    @Autowired
    private AdminCategories metier;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("listCategories", metier.listCategories());
      
        return "categories";
    }

}
