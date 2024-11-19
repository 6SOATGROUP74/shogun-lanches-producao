package com.example.demo.adapter.gateway.interfaces.producao;

import com.example.demo.core.domain.Producao;

import java.util.List;

public interface ListarProducaoAdapterPort {
   List<Producao> listarTodasProducoes();
   Producao listarPorNumeroPedido(String numeroPedido);
}