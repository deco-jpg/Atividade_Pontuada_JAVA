package com.example.AtividadePontuadaAPI.controller;

import com.example.AtividadePontuadaAPI.model.Funcionario;
import com.example.AtividadePontuadaAPI.service.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    public ResponseEntity<Map<String, String>> criar(@RequestBody Funcionario f) {
        service.adicionar(f);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Funcionario Cadastrado com sucesso."));
    }

    @GetMapping
    public List<Funcionario> listar() {
        return service.listar();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(@PathVariable Long id, @RequestBody Funcionario f) {
        service.atualizar(id, f);
        return ResponseEntity.ok(Map.of("mensagem", "Funcionario Atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok(Map.of("mensagem", "Funcionario Deletado com sucesso."));
    }
}