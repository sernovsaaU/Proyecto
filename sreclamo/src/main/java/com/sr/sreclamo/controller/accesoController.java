package com.sr.sreclamo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class accesoController {
    /*
    @GetMapping("/")
        public String home(){
            //return ("<h1>Bienvenido</h1>");
           return "login";
    }
*/
    @GetMapping("/trabajador")
        public String trabajador(){
        return ("<h1>Bienvenido trabajador</h1>");
    }

    @GetMapping("/admin")
        public String admin(){
        return ("<h1>Bienvenido admin</h1>");
    }


    @GetMapping("/comite")
        public String comite(){
            return ("<h1>Bienvenido comite</h1>");
    }

}
