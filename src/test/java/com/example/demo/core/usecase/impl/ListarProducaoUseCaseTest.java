package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.gateway.interfaces.producao.ListarProducaoAdapterPort;
import com.example.demo.core.domain.Producao;
import static com.example.demo.mocks.ProducaoHelper.gerarProducao;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

class ListarProducaoUseCaseTest {

    ListarProducaoAdapterPort listarProducaoAdapterPort = mock(ListarProducaoAdapterPort.class);
    ListarProducaoUseCase listarProducaoUseCase = new ListarProducaoUseCase(listarProducaoAdapterPort);

    @Test
    public void deveListarTodasProducoesComSucesso(){
        Producao producao = gerarProducao();
        List<Producao> listaProducao = Arrays.asList(producao);

        when(listarProducaoAdapterPort.listarTodasProducoes()).thenReturn(listaProducao);

        listarProducaoUseCase.execute();

        verify(listarProducaoAdapterPort, times(1)).listarTodasProducoes();
    }

    @Test
    public void deveListarProducaoPorNumeroPedidoComSucesso(){
        Long producaoId = 1L;
        Producao producao = gerarProducao();

        when(listarProducaoAdapterPort.listarPorNumeroPedido(producaoId)).thenReturn(producao);

        listarProducaoUseCase.listarPorNumeroPedido(producaoId);

        verify(listarProducaoAdapterPort, times(1)).listarPorNumeroPedido(anyLong());
    }
}