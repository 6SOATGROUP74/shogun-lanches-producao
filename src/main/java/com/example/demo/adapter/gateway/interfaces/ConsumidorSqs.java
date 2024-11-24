package com.example.demo.adapter.gateway.interfaces;

import com.example.demo.adapter.controller.request.common.ProducaoRequest;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorSqs {

    private static final Logger logger = LoggerFactory.getLogger(ConsumidorSqs.class);

    @SqsListener("producao")
    public void listen(ProducaoRequest producaoRequest) {
        logger.info("Pedido recebido na cozinha - {}", producaoRequest);
    }

}