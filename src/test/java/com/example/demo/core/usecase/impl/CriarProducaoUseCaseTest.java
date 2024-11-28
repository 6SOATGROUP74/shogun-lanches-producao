package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.controller.request.pedido.AtualizaPedidoRequest;
import com.example.demo.adapter.gateway.interfaces.impl.AtualizarProducaoAdapter;
import com.example.demo.adapter.gateway.interfaces.impl.BuscarProducaoAdapter;
import com.example.demo.adapter.gateway.interfaces.producao.NotificaConclusaoPedidoAdapterPort;
import com.example.demo.core.domain.Producao;
import com.example.demo.core.domain.StatusPedido;
import static com.example.demo.mocks.ProducaoHelper.gerarProducao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CriarProducaoUseCaseTest {

    AtualizarProducaoAdapter atualizarProducaoAdapter = mock(AtualizarProducaoAdapter.class);
    BuscarProducaoAdapter buscarProducaoAdapter = mock(BuscarProducaoAdapter.class);
    NotificaConclusaoPedidoAdapterPort notificaConclusaoPedidoAdapterPort = mock(NotificaConclusaoPedidoAdapterPort.class);
    CriarProducaoUseCase criarProducaoUseCase = new CriarProducaoUseCase(atualizarProducaoAdapter, buscarProducaoAdapter, notificaConclusaoPedidoAdapterPort);

    @Test
    public void deveProduzirPedidoComSucesso(){
        ArgumentCaptor<Producao> captorProducao = ArgumentCaptor.forClass(Producao.class);
        ArgumentCaptor<AtualizaPedidoRequest> captorAtualizaPedido = ArgumentCaptor.forClass(AtualizaPedidoRequest.class);
        Producao producao = gerarProducao();

        when(buscarProducaoAdapter.execute(producao.getIdProducao())).thenReturn(producao);
        when(atualizarProducaoAdapter.execute(captorProducao.capture())).thenReturn(producao);
        doNothing().when(notificaConclusaoPedidoAdapterPort).execute(captorAtualizaPedido.capture());

        criarProducaoUseCase.criarProducao(producao);
        Assertions.assertEquals(StatusPedido.PRONTO.name(), captorProducao.getValue().getEtapa());
        Assertions.assertEquals(producao.getNumeroPedido(), captorAtualizaPedido.getValue().getNumeroPedido());
    }
}