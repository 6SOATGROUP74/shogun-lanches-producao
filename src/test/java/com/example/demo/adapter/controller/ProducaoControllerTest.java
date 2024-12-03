package com.example.demo.adapter.controller;

import com.example.demo.adapter.controller.request.pedido.AtualizaPedidoRequest;
import com.example.demo.core.domain.StatusPedido;
import com.example.demo.infrastructure.pedido.ShogunPedidoClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class ProducaoControllerTest {

    private MockMvc mockMvc;

    AutoCloseable opeMocks;

    @Mock
    ShogunPedidoClient shogunPedidoClient;

    @BeforeEach
    void setup() {
        opeMocks = MockitoAnnotations.openMocks(this);
        ProducaoController producaoController = new ProducaoController(shogunPedidoClient);
        mockMvc = MockMvcBuilders.standaloneSetup(producaoController)
                .addFilter((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                }, "/*")
                .build();
    }

    @Test
    void deveRealizarPagamento() throws Exception {
        var atualizar = AtualizaPedidoRequest.builder().numeroPedido(1L).etapa(StatusPedido.PRONTO.name()).build();
        when(shogunPedidoClient.notificaConclusaoDoPedido(atualizar))
                .thenAnswer(i -> i.getArgument(0));

        mockMvc.perform(post("/v1/producao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(atualizar)))
                .andDo(print())
                .andExpect(status().isOk());

        verify(shogunPedidoClient, times(1)).notificaConclusaoDoPedido(any());
    }

    @AfterEach
    void tearDown() throws Exception {
        opeMocks.close();
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}