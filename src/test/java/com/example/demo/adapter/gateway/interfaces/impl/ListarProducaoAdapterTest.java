package com.example.demo.adapter.gateway.interfaces.impl;


import com.example.demo.core.domain.Producao;
import com.example.demo.infrastructure.repository.ProducaoRepository;
import com.example.demo.infrastructure.repository.entity.ProducaoEntity;
import static com.example.demo.mocks.ProducaoHelper.gerarProducao;
import static com.example.demo.mocks.ProducaoHelper.gerarProducaoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

class ListarProducaoAdapterTest {

    ProducaoRepository producaoRepository = mock(ProducaoRepository.class);
    ListarProducaoAdapter listarProducaoAdapter = new ListarProducaoAdapter(producaoRepository);

    @Test
    public void deveListarTodasProducoesComSucesso(){
        Producao producao = gerarProducao();
        ProducaoEntity producaoEntity = gerarProducaoEntity(producao);

        when(producaoRepository.findAll()).thenReturn(Arrays.asList(producaoEntity));

        var result = listarProducaoAdapter.listarTodasProducoes();

        verify(producaoRepository, times(1)).findAll();
        Assertions.assertEquals(producao.getNumeroPedido(), result.get(0).getNumeroPedido());
    }

    @Test
    public void naoDeveListarProducoesQuandoNaoExistir(){

        when(producaoRepository.findAll()).thenReturn(null);

        var result = listarProducaoAdapter.listarTodasProducoes();

        verify(producaoRepository, times(1)).findAll();
        Assertions.assertNull(result);
    }

    @Test
    public void deveListarProducaoPeloNumeroDoPedidoComSucesso(){
        Long numeroPedido = 1L;
        Producao producao = gerarProducao();
        ProducaoEntity producaoEntity = gerarProducaoEntity(producao);

        when(producaoRepository.findByNumeroPedido(numeroPedido)).thenReturn(producaoEntity);

        var result = listarProducaoAdapter.listarPorNumeroPedido(numeroPedido);

        verify(producaoRepository, times(1)).findByNumeroPedido(any());
        Assertions.assertEquals(producao.getNumeroPedido(), result.getNumeroPedido());
    }

    @Test
    public void naoDeveListarProducaoPeloNumeroDoPedido(){
        Long numeroPedido = 1L;
        Producao producao = gerarProducao();
        ProducaoEntity producaoEntity = gerarProducaoEntity(producao);

        when(producaoRepository.findByNumeroPedido(numeroPedido)).thenReturn(null);

        var result = listarProducaoAdapter.listarPorNumeroPedido(numeroPedido);

        verify(producaoRepository, times(1)).findByNumeroPedido(any());
        Assertions.assertNull(result);
    }
}