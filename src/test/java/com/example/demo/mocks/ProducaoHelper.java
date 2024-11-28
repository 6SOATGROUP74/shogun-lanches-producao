package com.example.demo.mocks;

import com.example.demo.core.domain.Producao;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.infrastructure.repository.entity.ProducaoEntity;

import java.time.LocalDateTime;

public class ProducaoHelper {

    public static Producao gerarProducao() {
        Producao producao = new Producao();
        producao.setIdProducao(1L);
        producao.setIdPagamento(1L);
        producao.setNumeroPedido(1L);
        producao.setEtapa(StatusPedido.EM_PREPARACAO.name());
        producao.setDataCriacao(LocalDateTime.now().toString());
        producao.setDataAtualizacao(LocalDateTime.now().toString());
        return producao;
    }

    public static ProducaoEntity gerarProducaoEntity(Producao producao) {
        ProducaoEntity producaoEntity = new ProducaoEntity();
        producaoEntity.setIdPagamento(producao.getIdProducao());
        producaoEntity.setIdPagamento(producao.getIdPagamento());
        producaoEntity.setNumeroPedido(producao.getNumeroPedido());
        producaoEntity.setEtapa(producao.getEtapa());
        producaoEntity.setDataCriacao(producao.getDataCriacao());
        producaoEntity.setDataAtualizacao(producao.getDataAtualizacao());
        return producaoEntity;
    }

}
