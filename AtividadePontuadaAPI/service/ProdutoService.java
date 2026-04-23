package com.example.AtividadePontuadaAPI.service;

import com.example.AtividadePontuadaAPI.model.Produto;
import com.example.AtividadePontuadaAPI.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Produto adicionar(Produto p) {
        if (repository.findByLote(p.getLote()).isPresent()) {
            throw new RuntimeException("Lote já cadastrado.");
        }

        return repository.save(p);
    }

    public Produto atualizar(Long id, Produto p) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }

        p.setId(id);
        return repository.save(p);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }

        repository.deleteById(id);
    }
}