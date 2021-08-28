package com.sr.sreclamo.controller;


import java.util.List;
import java.util.Optional;

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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

 
  

  @RequestMapping(value ="/mulReclamos", method = RequestMethod.GET)
  public String multReclamos(@RequestParam (name="entregaX")Integer entregaX,@RequestParam (name="entregaX2")Integer entregaX2, Model model) {
    List<reclamo> busquedaMultiReclamo= RS.multiBusquedaReclamos(entregaX,entregaX2);
    model.addAttribute("busquedaMultiReclamo", busquedaMultiReclamo);
    return "multReclamos";
  }

  /*
   @RequestMapping(value ="/mulReclamos", method = RequestMethod.GET)
  public String multReclamos(@RequestParam (name="entregaX")String entregaX,@RequestParam (name="entregaX2")String entregaX2, Model model) {
    List<reclamo> busquedaMultiReclamo= RS.multiBusquedaReclamos(entregaX,entregaX2);
    model.addAttribute("busquedaMultiReclamo", busquedaMultiReclamo);
    return "multReclamos";
  }
  */
  //mostrar relcamos oficial
  @GetMapping("/listartodor")
  public String listarTodo(Model model){
      List<reclamo> listaR = RS.listAllReclamos();
      List<reclamoEnti> entiReclamos= RS.modelToEntity(listaR);
      model.addAttribute("entiReclamos", entiReclamos);
    return "listr";
  }
 
  //guardar reclamo? pnediente
  @PostMapping("/guardarReclamo2")  
  public String guardarReclamo(@ModelAttribute("reclamo") reclamo r){
    RS.guardaReclamo(r);
    return "redirect:/listartodor";

  }

 //vista de pruebas de drop down con cliente, borrar
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
  
  //funcionalidad guardar, debe mantenerse
  @GetMapping("/selec2")
  public String formularioParaIngreso(Model model){

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
   //respuesta funcionalidad guardar, debe mantenerse
  @PostMapping("/selecResp2")  
  public String guardarReclamos(@ModelAttribute("reclamoEnti") reclamoEnti nvoReclamo){
    System.out.println("reclamo pk: "+nvoReclamo.getRrec().getNumero_Reclamo() );
    System.out.println("reclamo pk: "+nvoReclamo.getRrec().getCodigo_Interno_Reclamo() );
    if(nvoReclamo.getRrec().getCodigo_Interno_Reclamo()==null){
      System.out.println("Recepcion selecResp2, formulario de ingreso, control");
      System.out.println("CLiente");

      System.out.println("Seleccion y entrego id: " + nvoReclamo.getRrec().getClienteIdCliente());
      System.out.println("Fruta y entrego id: " + nvoReclamo.getRrec().getTipo_Fruta_Id_Tipo_Fruta());
      System.out.println("marca y entrego id: " + nvoReclamo.getRrec().getMarca_Id_Marca());
      System.out.println("Producto y entrego id: " + nvoReclamo.getRrec().getTipo_Producto_Id_Producto());
      System.out.println("estado  y entrego id: " + nvoReclamo.getRrec().getEstado_Id_estado());
      RS.guardaReclamo(nvoReclamo.getRrec());
    }  else{
      System.out.println("Esto deberia ser ya no cumple: " +nvoReclamo.getRrec().getDetalle_Reclamo());
      RS.update(nvoReclamo.getRrec());

      
    }
    return "redirect:/selec2";
  
  }
  //buscar reclamo
  @GetMapping("/buscarReclamosConParametros")
  public String buscarConPramaetros(Model model){
    System.out.println("Entro en la pre-busqueda con parametros");
      
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
    System.out.println("Saliendo de la pre-busqueda con parametros");
    return "buscarReclamosP";
  }
    //respuesta de buscar reclamo
  @PostMapping("/rbp")
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  public String respuestaBConPramaetros(@ModelAttribute("reclamoEnti") reclamoEnti nvoReclamo, Model model){
    System.out.println("Entro en la busqueda con parametros");
     


    ///debe hacer lo sigueiente:
    //buscar con x parametros,  que deben estar en reclamoenti.reclamo y pasarselo a una funcion.
    System.out.println("Ingresaste temporada reclamo:" +nvoReclamo.getRrec().getTemporada_Recepcion_Reclamo_1() + "?");
    System.out.println("Ingresaste cliente:" +nvoReclamo.getRrec().getClienteIdCliente() + "?");
    
    System.out.println("Ingresaste fecha:" +nvoReclamo.getRrec().getFecha_Recepcion_Reclamo() + "?");
    reclamo consulta=nvoReclamo.getRrec();
    
    
    System.out.println("Se realiza la consulta en la BD: ");
    List<reclamo> busca= RS.buscaConP(consulta);

    //luego gardarla en el model  
    long cantidad=RS.cantidadR();
    long tamaño=busca.size();
    System.out.println("Total colsuta:" + cantidad);
    System.out.println("Total registros en BD:" + tamaño);
    if(busca.size()==cantidad || tamaño==0){
      return "busquedaSinResultado";
    }
    List<reclamoEnti> busquedaMultiReclamo= RS.modelToEntity(busca);
    //luego gardarla en el model  
    model.addAttribute("busquedaMultiReclamo", busquedaMultiReclamo);
    // luego pasarla a una vista

    // debe ser listarrodo? el hace deploy de datos en vista... talvez habra que hacer una vista custom
    System.out.println("Sale, ahy extio?");
    System.out.println("Sale arreglo tamaño: "+ busquedaMultiReclamo.size());
    System.out.println("Ingresaste:" +nvoReclamo.getRrec().getTemporada_Recepcion_Reclamo_1() + "?");
    System.out.println("Ingresaste cliente:" +nvoReclamo.getRrec().getClienteIdCliente() + "?");
    
    System.out.println("Ingresaste fecha:" +nvoReclamo.getRrec().getFecha_Recepcion_Reclamo() + "?");
    return "customRespuesta";
  }
  //editar, funcionando
  @GetMapping("/edit/{Numero_Reclamo}")
  public String edit(@PathVariable("Numero_Reclamo") Integer Numero_Reclamo, Model model){
    reclamoEnti nvoReclamo=RS.formar(Numero_Reclamo);
    model.addAttribute("nvoReclamo",nvoReclamo);
    
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
    return "sele2";
  }
  
}
