package com.sr.sreclamo.service;

import java.util.ArrayList;
import java.util.List;

import com.sr.sreclamo.entity.reclamoEnti;
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

    public List<reclamo> listAllReclamos(){
        return repoR.findAll();
    }

    public reclamo guardaReclamo(reclamo R){
        return repoR.save(R);
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
            System.out.println("valor i del for: " + i);
            Integer buscaConEsteId=lista.get(i).getTipo_Fruta_Id_Tipo_Fruta();
            System.out.println("El tamaño es: "+lista.size());
            System.out.println("El idfruta es: "+buscaConEsteId);
            tipo_fruta f=FS.buscarNombreConId(buscaConEsteId);
            System.out.println("Fruta obetenida");
            reclamoEnti nuevaEntidad=new reclamoEnti(f,lista.get(i));
            System.out.println("Fruta asiganda");
            System.out.println("Reclamo asiganda");
            entidades.add(nuevaEntidad);
            System.out.println("Entidad asginada a lista");
           
        }
        System.out.println("Control de salida");
        return entidades;
    }
}
