package com.example.demo.core.usecase.impl;

import com.example.demo.core.domain.Producao;
import com.example.demo.core.usecase.interfaces.producao.BuscarProducaoUseCasePort;
import com.example.demo.infrastructure.repository.ProducaoRepository;
import com.example.demo.infrastructure.repository.entity.ProducaoEntity;
import com.example.demo.infrastructure.repository.presenter.ProducaoEntityMapper;

import java.util.Optional;

public class BuscarProducaoUseCase implements BuscarProducaoUseCasePort {

    private final ProducaoRepository producaoRepository;

    public BuscarProducaoUseCase(ProducaoRepository pedidoRepository) {
        this.producaoRepository = pedidoRepository;
    }

    @Override
    public Producao buscarPorId(Long idProducao) {
        Optional<ProducaoEntity> pedidoEntity = producaoRepository.findById(idProducao);
        return ProducaoEntityMapper.INSTANCE.mapFrom(pedidoEntity.get());
    }
}
