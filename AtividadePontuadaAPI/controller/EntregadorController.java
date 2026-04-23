package com.example.AtividadePontuadaAPI.controller;

import com.example.AtividadePontuadaAPI.model.Entregador;
import com.example.AtividadePontuadaAPI.service.EntregadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorService service;

    @PostMapping
    public ResponseEntity<Map<String, String>> criar(@RequestBody Entregador e) {
        service.adicionar(e);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Entregador Cadastrado com sucesso."));
    }

    @GetMapping
    public List<Entregador> listar() {
        return service.listar();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(@PathVariable Long id, @RequestBody Entregador e) {
        service.atualizar(id, e);
        return ResponseEntity.ok(Map.of("mensagem", "Entregador Atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok(Map.of("mensagem", "Entregador Deletado com sucesso."));
    }
}