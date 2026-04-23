package com.example.AtividadePontuadaAPI.service;

import com.example.AtividadePontuadaAPI.model.Entregador;
import com.example.AtividadePontuadaAPI.repository.EntregadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    public List<Entregador> listar() {
        return repository.findAll();
    }

    public Entregador adicionar(Entregador e) {
        if (repository.findByEmail(e.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado.");
        }

        return repository.save(e);
    }

    public Entregador atualizar(Long id, Entregador e) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Entregador não encontrado.");
        }

        e.setId(id);
        return repository.save(e);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Entregador não encontrado.");
        }

        repository.deleteById(id);
    }
}