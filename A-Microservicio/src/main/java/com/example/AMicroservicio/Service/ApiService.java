package com.example.AMicroservicio.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private static final String SERVICE_NAME = "apiA";

    @CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "getError")
    public String llamarApiB(String mensaje) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:9002/apiB/" + mensaje;
        return restTemplate.getForObject(apiUrl, String.class);
    }

    public String llamarApiBSinCB(String mensaje) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:9002/apiB/" + mensaje;
        return restTemplate.getForObject(apiUrl, String.class);
    }

    public String getError(Exception e) {
        return "Error: No se pudo comunicar con la API B";
    }

}
