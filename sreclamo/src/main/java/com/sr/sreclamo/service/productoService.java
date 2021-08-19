package com.sr.sreclamo.service;

import java.util.List;

import com.sr.sreclamo.model.producto;
import com.sr.sreclamo.repo.productoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productoService {

    @Autowired
    private productoRepo pRepo;

    public List<producto> listaAllProductos(){
        return pRepo.findAll();
    }

    public producto buscarProductos(Integer id){
        return pRepo.getById(id);
    }
    
    public producto buscarNombreConId(Integer buscaConEsteId){
        return pRepo.buscarNombrePorId(buscaConEsteId);
    }
    
}
