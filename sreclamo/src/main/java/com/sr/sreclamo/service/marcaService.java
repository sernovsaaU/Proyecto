package com.sr.sreclamo.service;

import java.util.List;

import com.sr.sreclamo.model.marca;
import com.sr.sreclamo.repo.marcaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class marcaService {

    @Autowired
    private marcaRepo mRepo;

    public List<marca> listaAllMarca(){
        return mRepo.findAll();
    }

    public marca buscarMarca(Integer id){
        return mRepo.getById(id);
    }
    
    public marca buscarNombreConId(Integer buscaConEsteId){
        return mRepo.buscarNombrePorId(buscaConEsteId);
    }
    
}
