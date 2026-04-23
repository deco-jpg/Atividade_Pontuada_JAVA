package com.example.AtividadePontuadaAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AtividadePontuadaAPI.model.Funcionario;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByEmail(String email);
    Optional<Funcionario> findByCpf(String cpf);
}