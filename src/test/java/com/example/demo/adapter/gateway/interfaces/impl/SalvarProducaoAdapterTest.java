package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Producao;
import com.example.demo.infrastructure.repository.ProducaoRepository;
import com.example.demo.infrastructure.repository.entity.ProducaoEntity;
import static com.example.demo.mocks.ProducaoHelper.gerarProducao;
import static com.example.demo.mocks.ProducaoHelper.gerarProducaoEntity;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SalvarProducaoAdapterTest {

    ProducaoRepository producaoRepository = mock(ProducaoRepository.class);
    SalvarProducaoAdapter salvarProducaoAdapter = new SalvarProducaoAdapter(producaoRepository);

    @Test
    public void deveSalvarProducaoComSucesso(){
        Producao producao = gerarProducao();
        ProducaoEntity producaoEntity = gerarProducaoEntity(producao);

        when(producaoRepository.save(producaoEntity)).thenReturn(producaoEntity);

        salvarProducaoAdapter.execute(producao);

        verify(producaoRepository, times(1)).save(any());
    }
}