package com.example.demo.infrastructure.pedido;

import com.example.demo.adapter.controller.request.pedido.AtualizaPedidoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "ShogunPedidoClient", url = "${shogun.lanches.pedido.url}")
public interface ShogunPedidoClient {

    @PutMapping(value = "/v1/pedidos/notifica-producao-concluida",consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> notificaConclusaoDoPedido(@RequestBody AtualizaPedidoRequest atualizaPedidoRequest);

}
