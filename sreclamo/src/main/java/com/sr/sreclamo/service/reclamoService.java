package com.sr.sreclamo.service;

import java.util.ArrayList;
import java.util.List;

import com.sr.sreclamo.entity.reclamoEnti;
import com.sr.sreclamo.model.cliente;
import com.sr.sreclamo.model.estado;
import com.sr.sreclamo.model.marca;
import com.sr.sreclamo.model.producto;
import com.sr.sreclamo.model.reclamo;
import com.sr.sreclamo.model.tipo_fruta;
import com.sr.sreclamo.repo.reclamoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class reclamoService {
    @Autowired
    private reclamoRepo repoR;
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


    public List<reclamo> listAllReclamos(){
        return repoR.findAll();
    }

    //cambio reclamo por void y se quita return
    public void guardaReclamo(reclamo R){
        System.out.println("codigo interno:" + R.getCodigo_Interno_Reclamo());
        System.out.println("Detalle:" + R.getDetalle_Reclamo());
        System.out.println("codigo interno:" + R.getFecha_Recepcion_Reclamo());        
        R.getClienteIdCliente();
        repoR.save(R);
    }

    public reclamo buscarReclamoPOrID(reclamo R){
        return repoR.getById(R.getNumero_Reclamo());
    }

    public void modificar(){}

    public List<reclamo> multiBusquedaReclamos(String entregaX,String entregaX2){
        return repoR.busquedaCompleja(entregaX,entregaX2);
    }

    public List<reclamoEnti> modelToEntity(List<reclamo> lista){
        List<reclamoEnti> entidades= new ArrayList<reclamoEnti>();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("El tamaño es: "+lista.size() +"valor i del for: " + i);
            
            Integer buscaConEsteId=lista.get(i).getTipo_Fruta_Id_Tipo_Fruta();
            
            System.out.println("El idfruta es: "+buscaConEsteId);
            tipo_fruta f=FS.buscarNombreConId(buscaConEsteId);
            System.out.println("Fruta obetenida:" + f.getNombre_Tipo_Fruta());

            buscaConEsteId=lista.get(i).getClienteIdCliente();
            cliente c=CS.buscarNombreConId(buscaConEsteId);
            System.out.println("Cliente obetenido: " + c.getNombreCliente());

            buscaConEsteId=lista.get(i).getEstado_Id_estado();
            estado e=ES.buscarNombreConId(buscaConEsteId);
            System.out.println("Estado obetenida"+ e.getEstado());

            buscaConEsteId=lista.get(i).getTipo_Producto_Id_Producto();
            producto p=PS.buscarNombreConId(buscaConEsteId);
            System.out.println("Producto obetenida"+ e.getEstado());

            buscaConEsteId=lista.get(i).getMarca_Id_Marca();
            marca m=MS.buscarNombreConId(buscaConEsteId);
            System.out.println("Marca obetenida"+ e.getEstado());

            reclamoEnti nuevaEntidad=new reclamoEnti(lista.get(i),f,c,e,p,m);
   
            entidades.add(nuevaEntidad);
            System.out.println("Entidad asginada a lista");
           
        }
        System.out.println("Control de salida");
        return entidades;
    }
}
