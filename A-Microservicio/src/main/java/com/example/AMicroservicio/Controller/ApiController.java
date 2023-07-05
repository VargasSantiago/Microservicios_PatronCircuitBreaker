package com.example.AMicroservicio.Controller;

import com.example.AMicroservicio.Service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/apiA/{mensaje}")
    public String enviarMensaje(@PathVariable String mensaje) {
        return apiService.llamarApiB(mensaje);
    }

    @GetMapping("/apiA/sinCB/{mensaje}")
    public String enviarMensajeSinCB(@PathVariable String mensaje) {
        return apiService.llamarApiBSinCB(mensaje);
    }

}
