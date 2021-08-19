package com.sr.sreclamo.service;

import java.util.List;

import com.sr.sreclamo.model.cliente;
import com.sr.sreclamo.repo.clienteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clienteService {

    @Autowired
    private clienteRepo cRepo;

    public List<cliente> listaAllClientes(){
        return cRepo.findAll();
    }

    public cliente buscarClientes(Integer id){
        return cRepo.getById(id);
    }
    
    public cliente buscarNombreConId(Integer buscaConEsteId){
        return cRepo.buscarNombrePorId(buscaConEsteId);
    }
}
