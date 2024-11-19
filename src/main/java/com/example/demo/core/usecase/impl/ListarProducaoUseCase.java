package com.example.demo.core.usecase.impl;


import com.example.demo.adapter.gateway.interfaces.producao.ListarProducaoAdapterPort;
import com.example.demo.core.domain.Producao;
import com.example.demo.core.usecase.interfaces.producao.ListarProducaoUseCasePort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ListarProducaoUseCase implements ListarProducaoUseCasePort {

    private final ListarProducaoAdapterPort listarProducaoAdapterPort;

    public ListarProducaoUseCase(ListarProducaoAdapterPort listarProducaoAdapterPort) {
        this.listarProducaoAdapterPort = listarProducaoAdapterPort;
    }

    @Override
    public List<Producao> execute(){
        logger.info("m=execute, msg=Lista produções aleatoriamente");
        return listarProducaoAdapterPort.listarTodasProducoes();
    }

    @Override
    public Producao listarPorNumeroPedido(String numeroPedido) {
        logger.info("m=listarPorCodReferencia, msg=Lista por número de pedido={}", numeroPedido);
        return listarProducaoAdapterPort.listarPorNumeroPedido(numeroPedido);
    }

    private static final Logger logger = LogManager.getLogger(ListarProducaoUseCase.class);
}
