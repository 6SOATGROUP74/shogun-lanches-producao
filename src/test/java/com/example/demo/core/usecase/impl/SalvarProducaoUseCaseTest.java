package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.gateway.interfaces.producao.SalvarProducaoAdapterPort;
import com.example.demo.core.domain.Producao;
import static com.example.demo.mocks.ProducaoHelper.gerarProducao;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SalvarProducaoUseCaseTest {

    SalvarProducaoAdapterPort salvarProducaoAdapterPort = mock(SalvarProducaoAdapterPort.class);
    SalvarProducaoUseCase salvarProducaoUseCase = new SalvarProducaoUseCase(salvarProducaoAdapterPort);

    @Test
    public void deveSalvarProducaoComSucesso(){
        Producao producao = gerarProducao();

        when(salvarProducaoAdapterPort.execute(producao)).thenReturn(producao);

        salvarProducaoUseCase.execute(producao);

        verify(salvarProducaoAdapterPort, times(1)).execute(any());
    }

}