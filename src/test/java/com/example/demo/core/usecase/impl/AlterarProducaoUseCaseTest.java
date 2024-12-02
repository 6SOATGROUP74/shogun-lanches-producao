package com.example.demo.core.usecase.impl;


import com.example.demo.adapter.gateway.interfaces.producao.AtualizarProducaoAdapterPort;
import com.example.demo.core.domain.Producao;
import com.example.demo.core.usecase.interfaces.producao.BuscarProducaoUseCasePort;
import static com.example.demo.mocks.ProducaoHelper.gerarProducao;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AlterarProducaoUseCaseTest {

    AtualizarProducaoAdapterPort atualizarProducaoAdapterPort = mock(AtualizarProducaoAdapterPort.class);
    BuscarProducaoUseCasePort buscarProducaoUseCasePort = mock(BuscarProducaoUseCasePort.class);
    AlterarProducaoUseCase alterarProducaoUseCase = new AlterarProducaoUseCase(atualizarProducaoAdapterPort, buscarProducaoUseCasePort);

    @Test
    void deveAtualizarProducaoComSucesso(){
        Long producaoId = 1L;
        Producao producao = gerarProducao();

        when(buscarProducaoUseCasePort.buscarPorId(producaoId)).thenReturn(producao);
        when(atualizarProducaoAdapterPort.execute(producao)).thenReturn(producao);

        alterarProducaoUseCase.execute(producao);

        verify(buscarProducaoUseCasePort, times(1)).buscarPorId(anyLong());
        verify(atualizarProducaoAdapterPort, times(1)).execute(any());
    }
}