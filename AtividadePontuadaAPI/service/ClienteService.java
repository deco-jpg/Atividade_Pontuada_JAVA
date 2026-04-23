package com.example.AtividadePontuadaAPI.service;

import com.example.AtividadePontuadaAPI.model.Cliente;
import com.example.AtividadePontuadaAPI.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente adicionar(Cliente c) {
        if (repository.findByEmail(c.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado.");
        }

        return repository.save(c);
    }

    public Cliente atualizar(Long id, Cliente c) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        c.setId(id);
        return repository.save(c);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        repository.deleteById(id);
    }
}