package com.example.demo.core.usecase.impl;

import com.example.demo.core.domain.Producao;
import com.example.demo.core.usecase.interfaces.producao.AlterarProducaoUseCasePort;
import com.example.demo.core.usecase.interfaces.producao.BuscarProducaoUseCasePort;
import com.example.demo.adapter.gateway.interfaces.producao.AtualizarProducaoAdapterPort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AlterarProducaoUseCase implements AlterarProducaoUseCasePort {

    private final AtualizarProducaoAdapterPort atualizarProducaoAdapterPort;
    private final BuscarProducaoUseCasePort buscarProducaoUseCasePort;


    public AlterarProducaoUseCase(AtualizarProducaoAdapterPort atualizarProducaoAdapterPort, BuscarProducaoUseCasePort buscarProducaoUseCasePort) {
        this.atualizarProducaoAdapterPort = atualizarProducaoAdapterPort;
        this.buscarProducaoUseCasePort = buscarProducaoUseCasePort;
    }

    @Override
    public Producao execute(Producao producao) {
        Producao producaoEncontrada = buscarProducaoUseCasePort.buscarPorId(producao.getIdProducao());
        producaoEncontrada.setEtapa(producao.getEtapa());
        producaoEncontrada.setDataAtualizacao(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return atualizarProducaoAdapterPort.execute(producaoEncontrada);
    }
}
