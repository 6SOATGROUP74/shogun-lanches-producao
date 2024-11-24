package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.adapter.controller.request.common.ProducaoRequest;
import com.example.demo.adapter.gateway.interfaces.producao.ConsumidorProducaoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.producao.SalvarProducaoAdapterPort;
import com.example.demo.core.domain.Producao;
import com.example.demo.core.usecase.interfaces.producao.CriarProducaoUseCasePort;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConsumidorProducaoAdapter implements ConsumidorProducaoAdapterPort {

    private static final Logger logger = LoggerFactory.getLogger(ConsumidorProducaoAdapter.class);
    private final CriarProducaoUseCasePort criarProducaoUseCasePort;
    private final SalvarProducaoAdapterPort salvarProducaoAdapterPort;

    public ConsumidorProducaoAdapter(SalvarProducaoAdapterPort salvarProducaoAdapterPort, CriarProducaoUseCasePort criarProducaoUseCasePort) {
        this.salvarProducaoAdapterPort = salvarProducaoAdapterPort;
        this.criarProducaoUseCasePort = criarProducaoUseCasePort;
    }

    @SqsListener("producao")
    @Override
    public Producao consomeEvento(ProducaoRequest producaoRequest) {

        logger.info("Pedido recebido na cozinha - {}", producaoRequest);

        Producao producao = new Producao();
        producao.setIdPagamento(producaoRequest.getIdPagamento());
        producao.setNumeroPedido(producaoRequest.getNumeroPedido());
        producao.setEtapa(producaoRequest.getStatusPedido());
        producao.setDataCriacao(LocalDateTime.now().toString());
        producao.setDataAtualizacao(LocalDateTime.now().toString());

        Producao producaoRecebida = salvarProducaoAdapterPort.execute(producao);


        criarProducaoUseCasePort.criarProducao(producaoRecebida);

        return producaoRecebida;
    }
}
