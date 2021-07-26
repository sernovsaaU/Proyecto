package com.sr.sreclamo.service;

import java.util.List;

import com.sr.sreclamo.model.reclamo;
import com.sr.sreclamo.repo.reclamoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class reclamoService {
    @Autowired
    private reclamoRepo repo;

    public List<reclamo> listAllReclamos(){
        return repo.findAll();
    }

    public reclamo guardaReclamo(reclamo R){
        return repo.save(R);
    }

    public reclamo buscarReclamoPOrID(reclamo R){
        return repo.getById(R.getNumero_Reclamo());
    }

    public void modificar(){}

    public List<reclamo> multiBusquedaReclamos(String entregaX){
        return repo.busquedaCompleja(entregaX);
    }
}
