package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.adapter.controller.request.pedido.AtualizaPedidoRequest;
import com.example.demo.adapter.gateway.interfaces.producao.NotificaConclusaoPedidoAdapterPort;
import com.example.demo.infrastructure.pedido.ShogunPedidoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class NotificaConclusaoPedidoAdapter implements NotificaConclusaoPedidoAdapterPort {

    private static final Logger logger = LoggerFactory.getLogger(NotificaConclusaoPedidoAdapter.class);

    private ShogunPedidoClient shogunPedidoClient;

    public NotificaConclusaoPedidoAdapter(ShogunPedidoClient shogunPedidoClient) {
        this.shogunPedidoClient = shogunPedidoClient;
    }

    @Override
    public void execute(AtualizaPedidoRequest atualizaPedidoRequest) {

        logger.info("Notificando a conclusão do Pedido - {}", atualizaPedidoRequest);

        ResponseEntity responseEntity = shogunPedidoClient.notificaConclusaoDoPedido(atualizaPedidoRequest);

        logger.info("Notificação realizada com sucesso!, response={}", responseEntity);
    }
}
