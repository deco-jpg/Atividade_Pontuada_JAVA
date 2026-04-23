package com.example.AtividadePontuadaAPI.service;

import com.example.AtividadePontuadaAPI.model.Funcionario;
import com.example.AtividadePontuadaAPI.repository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> listar() {
        return repository.findAll();
    }

    public Funcionario adicionar(Funcionario f) {
        if (repository.findByEmail(f.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado.");
        }

        if (repository.findByCpf(f.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado.");
        }

        return repository.save(f);
    }

    public Funcionario atualizar(Long id, Funcionario f) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionário não encontrado.");
        }

        f.setId(id);
        return repository.save(f);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionário não encontrado.");
        }

        repository.deleteById(id);
    }
}