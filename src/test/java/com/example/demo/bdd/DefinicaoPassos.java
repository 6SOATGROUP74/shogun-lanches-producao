package com.example.demo.bdd;


import com.example.demo.adapter.controller.request.pedido.AtualizaPedidoRequest;
import com.example.demo.core.domain.StatusPedido;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class DefinicaoPassos {

    private Response response;

    private String ENDPOINT_PRODUCAO = "http://aa46e0980f4af4642aab860af6459ca8-1093881436.us-east-1.elb.amazonaws.com/v1/producao";

    @Quando("receber uma solicitação de notificação de conclusão de pedido")
    public void um_recebimento_de_uma_solicitação_de_pagamento() {
        AtualizaPedidoRequest atualizaPedidoRequest = AtualizaPedidoRequest.builder()
                .numeroPedido(15L)
                .etapa(StatusPedido.PRONTO.name()).build();

        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(atualizaPedidoRequest)
                .when()
                .post(ENDPOINT_PRODUCAO);
    }

    @Então("a notificação deverá ser realizada com sucesso")
    public void a_chamada_de_pagamento_de_qr_do_pag_bank_for_realizada() {
        response.then().statusCode(HttpStatus.CREATED.value());
    }
}
