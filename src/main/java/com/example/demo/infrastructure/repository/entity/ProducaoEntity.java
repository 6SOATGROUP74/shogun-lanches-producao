package com.example.demo.infrastructure.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_producao")
public class ProducaoEntity {

    @Id
    @Column(name = "id_producao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducao;

    @Column(name = "id_pagamento")
    private Long idPagamento;

    @Column(name = "numero_pedido")
    private Long numeroPedido;

    @Column(name = "etapa")
    private String etapa;

    @Column(name = "data_criacao")
    private String dataCriacao;

    @Column(name = "data_atualizacao")
    private String dataAtualizacao;

}
