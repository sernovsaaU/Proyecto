package com.sr.sreclamo.controller;

import java.util.List;

import com.sr.sreclamo.model.producto;
import com.sr.sreclamo.service.productoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class productoController {

    @Autowired
    private productoService pS;
       
    @GetMapping("/listarproductos")
    public String listarProductos(Model model) {
        List<producto>AllProductos = pS.listaAllProductos();
        model.addAttribute("AllProductos", AllProductos);
        return "producto";//vista html
    }  
    
    
}
