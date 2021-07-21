package com.sr.sreclamo.clasificacion;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Cla_RService{
    @Autowired
    private Cla_RRepo repo;
                        
    public List<Clasificacion_Reclamo> listAllClasificacion_Reclamo(){      
        return repo.findAll();
    }

    public Clasificacion_Reclamo saveClasificacion_Reclamo(Clasificacion_Reclamo cla_RM){
       return repo.save(cla_RM);
    }

    public Clasificacion_Reclamo getClasificacion_Reclamo(Integer id){
        return repo.getById(id);
    }
    public String deleteClasificacion_Reclamo(Integer id){
        repo.deleteById(id);
        return "Clasificacion de reclamo eliminada." +  id;
    }
}