package com.example.AtividadePontuadaAPI.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of("mensagem:", "Olá Mundo!");
    }

    @GetMapping("/dev")
    public Map<String, String> dev() {
        return Map.of("Feito por:", "Danilo Sena");
    }
}