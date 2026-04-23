package com.example.AtividadePontuadaAPI.controller;

import com.example.AtividadePontuadaAPI.model.Cliente;
import com.example.AtividadePontuadaAPI.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<Map<String, String>> criar(@RequestBody Cliente c) {
        service.adicionar(c);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Cliente Cadastrado com sucesso."));
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(@PathVariable Long id, @RequestBody Cliente c) {
        service.atualizar(id, c);
        return ResponseEntity.ok(Map.of("mensagem", "Cliente Atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok(Map.of("mensagem", "Cliente Deletado com sucesso."));
    }
}