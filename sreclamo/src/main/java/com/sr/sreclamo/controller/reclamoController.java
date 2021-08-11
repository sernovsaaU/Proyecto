package com.sr.sreclamo.controller;

import java.util.List;

import com.sr.sreclamo.model.reclamo;
import com.sr.sreclamo.service.reclamoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping
public class reclamoController {
    
    @Autowired
    private reclamoService RS;

    @PostMapping("/guardaReclamo")
    public String guardaReclamo(@RequestBody reclamo R){
        RS.guardaReclamo(R);
        return "crear_reclamos";
    }


/*
    @GetMapping("/listaReclamo")
    public re getMethodName(@RequestParam String param) {
        return new SomeData();
    }
  */
  
  @GetMapping("/listarReclamos")
  public String listarReclamos(Model model){
      List<reclamo>AllReclamo = RS.listAllReclamos();
      model.addAttribute("AllReclamo", AllReclamo);
    return "buscarreclamo";
  }

  @RequestMapping(value ="/mulReclamos", method = RequestMethod.GET)
  public String multReclamos(@RequestParam (name="entregaX")String entregaX,@RequestParam (name="entregaX2")String entregaX2, Model model) {
    List<reclamo> busquedaMultiReclamo= RS.multiBusquedaReclamos(entregaX,entregaX2);
    model.addAttribute("busquedaMultiReclamo", busquedaMultiReclamo);
    return "multReclamos";
  }
  
}
