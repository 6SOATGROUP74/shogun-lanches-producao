package com.example.demo.core.usecase.impl;

import com.example.demo.core.domain.Producao;
import com.example.demo.core.usecase.interfaces.producao.SalvarProducaoUseCasePort;
import com.example.demo.adapter.gateway.interfaces.producao.SalvarProducaoAdapterPort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SalvarProducaoUseCase implements SalvarProducaoUseCasePort {

    private static final Logger logger = LogManager.getLogger(SalvarProducaoUseCase.class);

    private final SalvarProducaoAdapterPort salvarProducaoAdapterPort;

    public SalvarProducaoUseCase(SalvarProducaoAdapterPort salvarProducaoAdapterPort) {
        this.salvarProducaoAdapterPort = salvarProducaoAdapterPort;
    }

    @Override
    public Producao execute(Producao producao) {
        logger.info("m=execute, msg=Persistindo no base de dados a producao={}", producao);
        return salvarProducaoAdapterPort.execute(producao);
    }
}
