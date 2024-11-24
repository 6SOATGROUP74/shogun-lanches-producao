package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.controller.request.pedido.AtualizaPedidoRequest;
import com.example.demo.adapter.gateway.interfaces.impl.AtualizarProducaoAdapter;
import com.example.demo.adapter.gateway.interfaces.impl.BuscarProducaoAdapter;
import com.example.demo.adapter.gateway.interfaces.impl.ConsumidorProducaoAdapter;
import com.example.demo.adapter.gateway.interfaces.producao.NotificaConclusaoPedidoAdapterPort;
import com.example.demo.core.domain.Producao;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.core.usecase.interfaces.producao.CriarProducaoUseCasePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Random;

public class CriarProducaoUseCase implements CriarProducaoUseCasePort {

    private static final Logger logger = LoggerFactory.getLogger(ConsumidorProducaoAdapter.class);

    private AtualizarProducaoAdapter atualizarProducaoAdapter;
    private BuscarProducaoAdapter buscarProducaoAdapter;
    private NotificaConclusaoPedidoAdapterPort notificaConclusaoPedidoAdapterPort;

    public CriarProducaoUseCase(AtualizarProducaoAdapter atualizarProducaoAdapter, BuscarProducaoAdapter buscarProducaoAdapter, NotificaConclusaoPedidoAdapterPort notificaConclusaoPedidoAdapterPort) {
        this.atualizarProducaoAdapter = atualizarProducaoAdapter;
        this.buscarProducaoAdapter = buscarProducaoAdapter;
        this.notificaConclusaoPedidoAdapterPort = notificaConclusaoPedidoAdapterPort;
    }

    @Override
    public Producao criarProducao(Producao producaoAtual) {

        logger.info("m=criarProducao, msg=Produzindo o pedido - {}", producaoAtual);

        Random random = new Random();

        // Gera um valor aleatório entre 5 e 15 segundos para simular o tempo de preparo
        int tempoDeProducaoDoPedido = 5 + random.nextInt(11); // random.nextInt(11) gera de 0 a 10

        try {
            Thread.sleep(tempoDeProducaoDoPedido * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Producao producao = buscarProducaoAdapter.execute(producaoAtual.getIdProducao());
        producao.setEtapa(StatusPedido.PRONTO.name());
        producao.setDataAtualizacao(LocalDateTime.now().toString());

        atualizarProducaoAdapter.execute(producao);

        logger.info("m=criarProducao, msg=Produção finalizada, pedido pronto para retirada - {}", producao);

        notificaConclusaoPedidoAdapterPort.execute(new AtualizaPedidoRequest(producao.getNumeroPedido(), producao.getEtapa()));

        return producao;
    }
}