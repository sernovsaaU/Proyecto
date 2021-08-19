package com.sr.sreclamo.service;

import java.util.List;

import com.sr.sreclamo.model.estado;
import com.sr.sreclamo.repo.estadoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class estadoService {

    @Autowired
    private estadoRepo eRepo;

    public List<estado> listaAllEstados(){
        return eRepo.findAll();
    }

    public estado buscarEstados(Integer id){
        return eRepo.getById(id);
    }
    
    public estado buscarNombreConId(Integer buscaConEsteId){
        return eRepo.buscarNombrePorId(buscaConEsteId);
    }
    
}
