package com.sr.sreclamo.controller;

import java.util.List;

import com.sr.sreclamo.model.fruta;
import com.sr.sreclamo.service.frutaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class frutaController {
    

    private frutaService FS;

    @GetMapping("/listaFrutas")
    public List<fruta> listadoFrutas(Model model) {
        List<fruta> allFrutas = FS.listaFrutas();
        return allFrutas;
    }
    

}
