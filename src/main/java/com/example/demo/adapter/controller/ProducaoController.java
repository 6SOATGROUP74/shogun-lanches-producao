package com.example.demo.adapter.controller;

import com.example.demo.adapter.controller.request.pedido.AtualizaPedidoRequest;
import com.example.demo.infrastructure.pedido.ShogunPedidoClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/producao")
public class ProducaoController {

    ShogunPedidoClient shogunPedidoClient;

    public ProducaoController(ShogunPedidoClient shogunPedidoClient) {
        this.shogunPedidoClient = shogunPedidoClient;
    }

    @PostMapping
    public ResponseEntity<?> notificaConclusaoDoPedido(@RequestBody AtualizaPedidoRequest atualizaPedidoRequest){
        return shogunPedidoClient.notificaConclusaoDoPedido(atualizaPedidoRequest);
    }

}
