package com.example.demo.adapter.gateway.interfaces.producao;

import com.example.demo.adapter.controller.request.pedido.AtualizaPedidoRequest;

public interface NotificaConclusaoPedidoAdapterPort {
    void execute(AtualizaPedidoRequest atualizaPedidoRequest);
}
