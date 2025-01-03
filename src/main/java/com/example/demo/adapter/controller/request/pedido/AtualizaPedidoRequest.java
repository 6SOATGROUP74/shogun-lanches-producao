package com.example.demo.adapter.controller.request.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@JsonPropertyOrder({ "numeroPedido", "etapa"})
public class AtualizaPedidoRequest {

    @JsonProperty("numero_pedido")
    private Long numeroPedido;

    private String etapa;

    public AtualizaPedidoRequest(Long numeroPedido, String etapa) {
        this.numeroPedido = numeroPedido;
        this.etapa = etapa;
    }
}
