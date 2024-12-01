package com.example.demo.adapter.gateway.interfaces.impl;


import com.example.demo.adapter.controller.request.common.ProducaoRequest;
import com.example.demo.adapter.gateway.interfaces.producao.SalvarProducaoAdapterPort;
import com.example.demo.core.domain.Producao;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.core.usecase.interfaces.producao.CriarProducaoUseCasePort;
import static com.example.demo.mocks.ProducaoHelper.gerarProducao;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ConsumidorProducaoAdapterTest {

    CriarProducaoUseCasePort criarProducaoUseCasePort = mock(CriarProducaoUseCasePort.class);
    SalvarProducaoAdapterPort salvarProducaoAdapterPort = mock(SalvarProducaoAdapterPort.class);
    ConsumidorProducaoAdapter consumidorProducaoAdapter = new ConsumidorProducaoAdapter(salvarProducaoAdapterPort, criarProducaoUseCasePort);

    @Test
    public void deveConsumirComSucessoEventoDeProducao() {
        ProducaoRequest producaoRequest = ProducaoRequest.builder().
                numeroPedido(1L)
                .idPagamento(1L)
                .statusPedido(StatusPedido.EM_PREPARACAO.name())
                .build();

        Producao producao = gerarProducao();

        when(salvarProducaoAdapterPort.execute(producao)).thenReturn(producao);
        when(criarProducaoUseCasePort.criarProducao(producao)).thenReturn(producao);

        consumidorProducaoAdapter.consomeEvento(producaoRequest);

        verify(salvarProducaoAdapterPort, times(1)).execute(any());
        verify(criarProducaoUseCasePort, times(1)).criarProducao(any());
    }
}