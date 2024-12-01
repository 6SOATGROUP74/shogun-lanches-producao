package com.example.demo.adapter.gateway.interfaces.impl;


import com.example.demo.core.domain.Producao;
import com.example.demo.infrastructure.repository.ProducaoRepository;
import com.example.demo.infrastructure.repository.entity.ProducaoEntity;
import static com.example.demo.mocks.ProducaoHelper.gerarProducao;
import static com.example.demo.mocks.ProducaoHelper.gerarProducaoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

class BuscarProducaoAdapterTest {

    ProducaoRepository producaoRepository = mock(ProducaoRepository.class);
    BuscarProducaoAdapter buscarProducaoAdapter = new BuscarProducaoAdapter(producaoRepository);

    @Test
    public void deveBuscarProducaoComSucesso(){
        Long producaoId = 1L;
        Producao producao = gerarProducao();
        ProducaoEntity producaoEntity = gerarProducaoEntity(producao);

        when(producaoRepository.findById(producaoId)).thenReturn(Optional.of(producaoEntity));


        var result = buscarProducaoAdapter.execute(producaoId);

        verify(producaoRepository, times(1)).findById(anyLong());
        Assertions.assertEquals(result.getNumeroPedido(), producao.getNumeroPedido());
    }

    @Test
    public void deveRetornarProducaoVaziaQuandoNaoExistir(){
        Long producaoId = 1L;

        when(producaoRepository.findById(producaoId)).thenReturn(Optional.empty());


        var result = buscarProducaoAdapter.execute(producaoId);

        verify(producaoRepository, times(1)).findById(anyLong());
        Assertions.assertNull(result);
    }
}