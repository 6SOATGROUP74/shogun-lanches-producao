package com.example.demo.adapter.gateway.interfaces.producao;

import com.example.demo.adapter.controller.request.common.ProducaoRequest;
import com.example.demo.core.domain.Producao;

public interface ConsumidorProducaoAdapterPort {
    Producao consomeEvento(ProducaoRequest producaoRequest);
}
