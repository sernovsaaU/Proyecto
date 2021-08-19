package com.sr.sreclamo.controller;


import java.util.List;

import com.sr.sreclamo.model.cliente;
import com.sr.sreclamo.service.clienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class clienteController {

    @Autowired
    private clienteService cS;

    
    @GetMapping("/listarClientes")
    public String listarFrutas(Model model) {
        List<cliente>AllClientes = cS.listaAllClientes();
        model.addAttribute("AllClientes", AllClientes);
        return "cliente";//vista html
    } 
    
    
}
