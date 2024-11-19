package com.example.demo.adapter.gateway.interfaces.producao;

import com.example.demo.core.domain.Producao;

public interface BuscarProducaoAdapterPort {
    Producao execute(Long idProducao);
}
