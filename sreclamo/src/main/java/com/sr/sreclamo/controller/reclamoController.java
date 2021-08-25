package com.sr.sreclamo.controller;

import java.util.List;

import com.sr.sreclamo.entity.reclamoEnti;
import com.sr.sreclamo.model.reclamo;
import com.sr.sreclamo.service.reclamoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping
public class reclamoController {
    
    @Autowired
    private reclamoService RS;

    @PostMapping("/guardaReclamo")
    public String guardaReclamo(@RequestBody reclamo R, @RequestParam String fecha1, @RequestParam String fecha2){
      Assert.notNull(R, "The entry cannot be null");
      RS.guardaReclamo(R);
      return "crear_reclamos";
    }

  
  @GetMapping("/listarReclamos")
  public String listarReclamos(Model model){
      List<reclamo>AllReclamo = RS.listAllReclamos();
      model.addAttribute("AllReclamo", AllReclamo);
    return "buscarreclamo";
  }

  @GetMapping("/listarReclamos2")
  public String listarReclamos2(Model model){
      List<reclamo> listaR = RS.listAllReclamos();
      List<reclamoEnti> entiReclamos= RS.modelToEntity(listaR);
      model.addAttribute("entiReclamos", entiReclamos);
    return "buscarreclamo2";
  }

  @RequestMapping(value ="/mulReclamos", method = RequestMethod.GET)
  public String multReclamos(@RequestParam (name="entregaX")String entregaX,@RequestParam (name="entregaX2")String entregaX2, Model model) {
    List<reclamo> busquedaMultiReclamo= RS.multiBusquedaReclamos(entregaX,entregaX2);
    model.addAttribute("busquedaMultiReclamo", busquedaMultiReclamo);
    return "multReclamos";
  }
  
  @GetMapping("/listartodor")
  public String listarTodo(Model model){
      List<reclamo> listaR = RS.listAllReclamos();
      List<reclamoEnti> entiReclamos= RS.modelToEntity(listaR);
      model.addAttribute("entiReclamos", entiReclamos);
    return "listr";
  }

  @GetMapping("/nuevoReclamo")
  public String nuevoReclamo(Model model){
    reclamo nvoReclamo= new reclamo();
    model.addAttribute("nvoReclamo", nvoReclamo);
    return "agregarNvoReclamo";

  }

  @PostMapping("/guardarReclamo2")  
  public String guardarReclamo(@ModelAttribute("reclamo") reclamo r){
    RS.guardaReclamo(r);
    return "redirect:/listartodor";

  }
}
/*
    @PostMapping("/guardaReclamo")
    @ResponseBody
    public String guardaReclamo(@RequestBody reclamo R){
      Assert.notNull(R, "The entry cannot be null");
      System.out.println("codigo interno:" + R.getCodigo_Interno_Reclamo());
        System.out.println("Detalle:" + R.getDetalle_Reclamo());
        System.out.println("codigo interno:" + R.getFecha_Recepcion_Reclamo());        
      RS.guardaReclamo(R);
      return "crear_reclamos";
    }

Codigo_Interno_Reclamo":2000,
    "Detalle_Reclamo":"yt1",
    "Fecha_Recepcion_Reclamo":"2019-12-12 00:00:00.0",
    "Temporada_Recepcion_Reclamo_1":2000,
    "Temporada_Recepcion_Reclamo_2":2000,
   "Fecha_Respuesta_Reclamo":"2019-12-12 00:00:00.0",
    "Temporada_Proceso_Reclamo_1":2000,
    "Temporada_Proceso_Reclamo_2":2000,
   "Estado_Id_estado":2,
    "Investigacion_Id_Investigacion":0,
    "Tipo_Producto_Id_Producto":1,
    "Marca_Id_Marca":1,
    "Tipo_Fruta_Id_Tipo_Fruta":1,
    "ClienteIdCliente":4,
    "Sub_Tipo_CR_Id_Sub_Tipo_CR":1

    @PostMapping("/guardaReclamo")
    public String guardaReclamo(@RequestBody reclamo R){
      Assert.notNull(R, "The entry cannot be null");
      System.out.println("codigo interno:" + R.getCodigo_Interno_Reclamo());
        System.out.println("Detalle:" + R.getDetalle_Reclamo());
        System.out.println("codigo interno:" + R.getFecha_Recepcion_Reclamo());        
      RS.guardaReclamo(R);
      return "crear_reclamos";
    }*/