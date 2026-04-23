package com.example.AtividadePontuadaAPI.repository;

import com.example.AtividadePontuadaAPI.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByLote(String lote);
}