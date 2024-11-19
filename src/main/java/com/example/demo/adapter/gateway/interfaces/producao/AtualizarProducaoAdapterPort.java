package com.example.demo.adapter.gateway.interfaces.producao;

import com.example.demo.core.domain.Producao;

public interface AtualizarProducaoAdapterPort {
    Producao execute(Producao producao);
}