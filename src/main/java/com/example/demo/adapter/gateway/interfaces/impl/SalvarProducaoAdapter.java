package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.adapter.controller.request.producao.mapper.ProducaoMapper;
import com.example.demo.adapter.gateway.interfaces.producao.SalvarProducaoAdapterPort;
import com.example.demo.core.domain.Producao;
import com.example.demo.infrastructure.repository.ProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarProducaoAdapter implements SalvarProducaoAdapterPort {

    private final ProducaoRepository producaoRepository;

    @Autowired
    public SalvarProducaoAdapter(ProducaoRepository producaoRepository) {
        this.producaoRepository = producaoRepository;
    }

    @Override
    public Producao execute(Producao producao) {
       return ProducaoMapper.INSTANCE.mapFrom(producaoRepository.save(ProducaoMapper.INSTANCE.mapFrom(producao)));
    }
}
