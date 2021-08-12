package com.sr.sreclamo.service;

import java.util.List;


import com.sr.sreclamo.model.tipo_fruta;
import com.sr.sreclamo.repo.frutaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class frutaService {
    
    @Autowired
    private frutaRepo fRepo;

    public List<tipo_fruta> listaAllFrutas(){
        return fRepo.findAll();
    }

    public tipo_fruta buscaFrutas(Integer Id){
        return fRepo.getById(Id);
    }

    public tipo_fruta buscarNombreConId(Integer buscaConEsteId){
        return fRepo.buscarNombrePorId(buscaConEsteId);
    }

}
