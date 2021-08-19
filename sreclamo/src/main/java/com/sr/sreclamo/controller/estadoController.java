package com.sr.sreclamo.controller;

import java.util.List;

import com.sr.sreclamo.model.estado;
import com.sr.sreclamo.service.estadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class estadoController {

    @Autowired
    private estadoService eS;

    
    @GetMapping("/listarEstado")
    public String listarEstado(Model model) {
        List<estado>AllEstado = eS.listaAllEstados();
        model.addAttribute("AllEstado", AllEstado);
        return "estado";//vista html
    }  
    
    
}
