package com.example.AtividadePontuadaAPI.repository;

import com.example.AtividadePontuadaAPI.model.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntregadorRepository extends JpaRepository<Entregador, Long> {
    Optional<Entregador> findByEmail(String email);
}