package com.example.AtividadePontuadaAPI.controller;

import com.example.AtividadePontuadaAPI.model.Produto;
import com.example.AtividadePontuadaAPI.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<Map<String, String>> criar(@RequestBody Produto p) {
        service.adicionar(p);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Produto Cadastrado com sucesso."));
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(@PathVariable Long id, @RequestBody Produto p) {
        service.atualizar(id, p);
        return ResponseEntity.ok(Map.of("mensagem", "Produto Funcionário Atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok(Map.of("mensagem", "Produto Funcionário Deletado com sucesso."));
    }
}