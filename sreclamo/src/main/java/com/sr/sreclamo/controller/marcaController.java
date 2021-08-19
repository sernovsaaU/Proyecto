package com.sr.sreclamo.controller;

import java.util.List;

import com.sr.sreclamo.model.marca;
import com.sr.sreclamo.service.marcaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class marcaController {

    @Autowired
    private marcaService mS;

    
    @GetMapping("/listarmarca")
    public String listaMarca(Model model) {
        List<marca>AllMarca = mS.listaAllMarca();
        model.addAttribute("AllMarca", AllMarca);
        return "marca";//vista html
    }  
    
    
}
