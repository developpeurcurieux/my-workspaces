/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easysoft.web.controller;

import com.easysoft.dao.repository.EtudiantRepository;
import com.easysoft.entites.Etudiant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author frup72134
 */
@Controller
@RequestMapping(value="/Etudiant")
public class EtudiantController {
    @Autowired
    private EtudiantRepository etudiantRepository;
    
    @GetMapping("/index")
    public String index(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        Page<Etudiant> pageEtudiants = etudiantRepository.findAll(new PageRequest(page, 5));
        
        
        int pagesCount = pageEtudiants.getTotalPages();
        int[] pages = new int[pagesCount];
        
        for(int i = 0; i < pagesCount ; i++) {
        	pages[i] = i;
        }
        
        model.addAttribute("pages", pages);        
        model.addAttribute("pageEtudiants", pageEtudiants);
        return "etudiants";
    }
}
