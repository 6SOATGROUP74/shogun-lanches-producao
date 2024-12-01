package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.adapter.gateway.interfaces.producao.BuscarProducaoAdapterPort;
import com.example.demo.core.domain.Producao;
import com.example.demo.infrastructure.repository.ProducaoRepository;
import com.example.demo.infrastructure.repository.presenter.ProducaoEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BuscarProducaoAdapter implements BuscarProducaoAdapterPort {

    private final ProducaoRepository producaoRepository;

    public BuscarProducaoAdapter(ProducaoRepository producaoRepository) {
        this.producaoRepository = producaoRepository;
    }

    @Override
    public Producao execute(Long idProducao) {
        logger.info("m=execute, msg=Consultando na base informações da producao, producaoId={}", idProducao);
        return ProducaoEntityMapper.INSTANCE.mapFrom(producaoRepository.findById(idProducao).orElse(null));
    }

    private Logger logger = LoggerFactory.getLogger(BuscarProducaoAdapter.class);
}
