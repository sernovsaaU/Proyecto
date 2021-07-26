package com.sr.sreclamo.service;

import java.util.List;


import com.sr.sreclamo.model.fruta;
import com.sr.sreclamo.repo.frutaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class frutaService {
    
    @Autowired
    private frutaRepo fRepo;

    public List<fruta> listaFrutas(){
        return fRepo.findAll();
    }

    public fruta buscaFrutas(Integer Id){
        return fRepo.getById(Id);
    } 
}
