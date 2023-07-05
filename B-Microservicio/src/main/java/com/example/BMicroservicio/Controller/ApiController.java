package com.example.BMicroservicio.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("/apiB/{mensaje}")
    public String recivirMensaje(@PathVariable String mensaje) {
        return "Mensaje recibido: " + mensaje;
    }
}
