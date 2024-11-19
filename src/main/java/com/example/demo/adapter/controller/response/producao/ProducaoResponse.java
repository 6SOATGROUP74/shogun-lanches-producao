package com.example.demo.adapter.controller.response.producao;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProducaoResponse {
    private Long idProducao;
    private String numeroPedido;
    private String etapa;
    private String dataCriacao;
    private String dataAtualizacao;
}
