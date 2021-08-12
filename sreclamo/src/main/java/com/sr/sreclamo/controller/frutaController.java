package com.sr.sreclamo.controller;

import java.util.List;


import com.sr.sreclamo.model.tipo_fruta;
import com.sr.sreclamo.service.frutaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping
public class frutaController {
    
    @Autowired
    private frutaService FS;

    @GetMapping("/listarFrutas")
    public String listarFrutas(Model model) {
        List<tipo_fruta>AllFrutas = FS.listaAllFrutas();
        model.addAttribute("AllFrutas", AllFrutas);
        return "fruta";//vista html
    }
    
    @RequestMapping(value ="/buscarFrutaPorId", method = RequestMethod.GET)
    public String buscarFrutaPorID(@RequestParam (name="buscaConEsteId")Integer buscaConEsteId,Model model) {
        tipo_fruta FrutaSolicitada = FS.buscarNombreConId(buscaConEsteId);
        model.addAttribute("FrutaSolicitada", FrutaSolicitada);
        return "/buscarFrutaPorId";//vista html
    }

}
