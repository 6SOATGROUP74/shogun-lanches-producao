package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.adapter.controller.request.producao.mapper.ProducaoMapper;
import com.example.demo.adapter.gateway.interfaces.producao.ListarProducaoAdapterPort;
import com.example.demo.core.domain.Producao;
import com.example.demo.infrastructure.repository.ProducaoRepository;
import com.example.demo.infrastructure.repository.presenter.ProducaoEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarProducaoAdapter implements ListarProducaoAdapterPort {

    private final ProducaoRepository producaoRepository;

    public ListarProducaoAdapter(ProducaoRepository producaoRepository) {
        this.producaoRepository = producaoRepository;
    }

    @Override
    public List<Producao> listarTodasProducoes() {
        return ProducaoEntityMapper.INSTANCE.mapFrom(producaoRepository.findAll());
    }

    @Override
    public Producao listarPorNumeroPedido(Long numeroPedido) {
        return ProducaoEntityMapper.INSTANCE.mapFrom(producaoRepository.findByNumeroPedido(numeroPedido));
    }
}
