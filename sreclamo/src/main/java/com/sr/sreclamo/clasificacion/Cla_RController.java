package com.sr.sreclamo.clasificacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping
public class Cla_RController {
  
  @Autowired
  private Cla_RService service;

  @PostMapping("/guardaClasificacion")
  public Clasificacion_Reclamo addClasificacion(@RequestBody Clasificacion_Reclamo clasificacionR){  
    return service.saveClasificacion_Reclamo(clasificacionR);
  }

  @GetMapping("/muestraClasificacion/")
  public List<Clasificacion_Reclamo> findClasificacion(){  
    return service.listAllClasificacion_Reclamo();  
  }
  

  //@RequestMapping("/clasificaciones") //(value = "/clasificacion", method = RequestMethod.GET)
  @GetMapping("/muestraClasificaciones")
  public String findAllClasificacion(Model model){  
    List<Clasificacion_Reclamo>ListCla_R =service.listAllClasificacion_Reclamo();
    model.addAttribute("ListCla_R",ListCla_R);  
     return "clasificacion";
  }

  @DeleteMapping ("/eliminaClasificacion/{Id_Clasificacion_Reclamo}")
  public String deleteClasificacion(@PathVariable  Integer Id_Clasificacion_Reclamo ){
    return service.deleteClasificacion_Reclamo(Id_Clasificacion_Reclamo);
  }
  

 
}