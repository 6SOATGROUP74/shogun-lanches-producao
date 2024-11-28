package com.example.demo.core.usecase.impl;

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

class BuscarProducaoUseCaseTest {

    ProducaoRepository producaoRepository = mock(ProducaoRepository.class);
    BuscarProducaoUseCase buscarProducaoUseCase = new BuscarProducaoUseCase(producaoRepository);

    @Test
    public void deveBuscarProducaoComSucesso() {
        Long producaoId= 1L;
        Producao producao = gerarProducao();
        ProducaoEntity producaoEntity = gerarProducaoEntity(producao);

        when(producaoRepository.findById(producaoId)).thenReturn(Optional.of(producaoEntity));

        var result =buscarProducaoUseCase.buscarPorId(producaoId);

        verify(producaoRepository, times(1)).findById(anyLong());
        Assertions.assertEquals(producao.getNumeroPedido(), result.getNumeroPedido());
    }

    @Test
    public void naoDeveEncontrarProducaoQuandoNaoExistir() {
        Long producaoId= 1L;

        when(producaoRepository.findById(producaoId)).thenReturn(null);

        Producao result = null;
        try {
            result = buscarProducaoUseCase.buscarPorId(producaoId);
            Assertions.fail();
        } catch (Exception e) {
            verify(producaoRepository, times(1)).findById(anyLong());
            Assertions.assertNull(result);
        }
    }

}