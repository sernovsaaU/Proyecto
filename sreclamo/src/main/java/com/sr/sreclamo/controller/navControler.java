package com.sr.sreclamo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class navControler {
    @GetMapping("/homeTrabajador")
    public String getHomeTrabajador(){
        return "homeTrabajador";
    }

    @GetMapping("/buscarreclamo")
    public String buscarreclamo(){
        return "buscarreclamo";
    }

    @GetMapping("/")
    public String inicioDeSesion(){
        return "login";
    }

    @GetMapping("/homeComite")
    public String getHomeComite(){
        return "homeTrabajador";
    }
    
}