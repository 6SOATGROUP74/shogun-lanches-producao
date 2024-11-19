package com.example.demo.core.usecase.interfaces.producao;

import com.example.demo.core.domain.Producao;

import java.util.List;

public interface ListarProducaoUseCasePort {
   List<Producao> execute();
   Producao listarPorNumeroPedido(String numeroPedido);
}