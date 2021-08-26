package com.sr.sreclamo.controller;

import java.util.List;
import java.util.Map;

import com.sr.sreclamo.entity.reclamoEnti;
import com.sr.sreclamo.model.cliente;
import com.sr.sreclamo.model.estado;
import com.sr.sreclamo.model.marca;
import com.sr.sreclamo.model.producto;
import com.sr.sreclamo.model.reclamo;
import com.sr.sreclamo.model.tipo_fruta;
import com.sr.sreclamo.service.clienteService;
import com.sr.sreclamo.service.estadoService;
import com.sr.sreclamo.service.frutaService;
import com.sr.sreclamo.service.marcaService;
import com.sr.sreclamo.service.productoService;
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
    @Autowired
    private frutaService FS;
    @Autowired
    private clienteService CS;
    @Autowired
    private estadoService ES;
    @Autowired
    private productoService PS;
    @Autowired
    private marcaService MS;

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

 
  @GetMapping("/selec")
  public String displaySelect(Model model){
    reclamoEnti nvoReclamo= new reclamoEnti();
    System.out.println("Este es el mapeado");
    List<cliente> clientes=CS.listaAllClientes();
    model.addAttribute("clientes", clientes);
  


    estado s=new estado();
    marca m=new marca();
    producto p= new producto();
    reclamo ms= new reclamo();
    tipo_fruta f=new tipo_fruta();
    nvoReclamo.setEst(s);
    nvoReclamo.setFru(f);
    nvoReclamo.setMar(m);
    nvoReclamo.setPro(p);
    nvoReclamo.setRrec(ms);
    
    
    model.addAttribute("nvoReclamo", nvoReclamo);
    return "sele";

  }

  @PostMapping("/selecResp")  
  public String selectRespuesta(@ModelAttribute("reclamoEnti") reclamoEnti nvoReclamo){
    System.out.println("QUe sucede, control");

    System.out.println("Seleccion y entrego nombre:" + nvoReclamo.getCli().getNombreCliente() + " y id: " + nvoReclamo.getCli().getIdCliente());


    
  
    return "redirect:/selec";
  }

  @GetMapping("/selec2")
  public String testestityR(Model model){

    reclamoEnti nvoReclamo= new reclamoEnti();
   
    List<cliente> clientes=CS.listaAllClientes();
    model.addAttribute("clientes", clientes);
    
    List<estado> estados=ES.listaAllEstados();
    model.addAttribute("estados", estados);

    List<marca> marcas=MS.listaAllMarca();
    model.addAttribute("marcas", marcas);

    List<producto> productos=PS.listaAllProductos();
    model.addAttribute("productos", productos);

    List<reclamo> reclamos=RS.listAllReclamos();
    model.addAttribute("reclamos", reclamos);

    List<tipo_fruta> tipo_frutas=FS.listaAllFrutas();
    model.addAttribute("tipo_frutas", tipo_frutas);
    
    estado s=new estado();
    marca m=new marca();
    producto p= new producto();
    reclamo ms= new reclamo();
    tipo_fruta f=new tipo_fruta();
    nvoReclamo.setEst(s);
    nvoReclamo.setFru(f);
    nvoReclamo.setMar(m);
    nvoReclamo.setPro(p);
    nvoReclamo.setRrec(ms);
    
    
    model.addAttribute("nvoReclamo", nvoReclamo);
    return "sele2";

  }

  

  
  @PostMapping("/selecResp2")  
  public String selectRespuesta2(@ModelAttribute("reclamoEnti") reclamoEnti nvoReclamo){
    System.out.println("QUe sucede, control");

    System.out.println("Seleccion y entrego nombre:" + nvoReclamo.getCli().getNombreCliente() + " y id: " + nvoReclamo.getCli().getIdCliente());


    
   
    return "redirect:/selec";

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