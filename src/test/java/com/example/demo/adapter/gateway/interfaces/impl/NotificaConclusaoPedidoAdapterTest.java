package com.example.demo.adapter.gateway.interfaces.impl;


import com.example.demo.adapter.controller.request.pedido.AtualizaPedidoRequest;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.infrastructure.pedido.ShogunPedidoClient;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class NotificaConclusaoPedidoAdapterTest {

    ShogunPedidoClient shogunPedidoClient = mock(ShogunPedidoClient.class);
    NotificaConclusaoPedidoAdapter notificaConclusaoPedidoAdapter = new NotificaConclusaoPedidoAdapter(shogunPedidoClient);

    @Test
    public void deveNoticarServicoPedidoComSucesso() {
        AtualizaPedidoRequest atualizaPedidoRequest = new AtualizaPedidoRequest(1L, StatusPedido.PRONTO.name());

        when(shogunPedidoClient.notificaConclusaoDoPedido(atualizaPedidoRequest)).thenReturn(ResponseEntity.status(HttpStatus.CREATED).build());

        notificaConclusaoPedidoAdapter.execute(atualizaPedidoRequest);

        verify(shogunPedidoClient, times(1)).notificaConclusaoDoPedido(any());
    }
}