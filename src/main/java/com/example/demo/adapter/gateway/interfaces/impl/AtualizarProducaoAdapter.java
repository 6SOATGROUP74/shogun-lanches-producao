package com.example.demo.adapter.gateway.interfaces.impl;


import com.example.demo.adapter.controller.request.producao.mapper.ProducaoMapper;
import com.example.demo.adapter.gateway.interfaces.producao.AtualizarProducaoAdapterPort;
import com.example.demo.core.domain.Producao;
import com.example.demo.infrastructure.repository.ProducaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AtualizarProducaoAdapter implements AtualizarProducaoAdapterPort {

    private final ProducaoRepository producaoRepository;

    public AtualizarProducaoAdapter(ProducaoRepository producaoRepository) {
        this.producaoRepository = producaoRepository;
    }

    @Override
    public Producao execute(Producao producao) {
        logger.info("m=execute, status=init, msg=Persistindo producao na base de dados, producao={}", producao);
        Producao producaoPersistida = ProducaoMapper.INSTANCE.mapFrom(producaoRepository.save(ProducaoMapper.INSTANCE.mapFrom(producao)));
        logger.info("m=execute, status=sucess, msg=Persistindo producao na base de dados, producao={}", producao);
        return producaoPersistida;
    }

    private final Logger logger = LoggerFactory.getLogger(AtualizarProducaoAdapter.class);
}
