package com.example.demo.config;

import com.example.demo.adapter.gateway.interfaces.impl.AtualizarProducaoAdapter;
import com.example.demo.adapter.gateway.interfaces.impl.BuscarProducaoAdapter;
import com.example.demo.adapter.gateway.interfaces.producao.AtualizarProducaoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.producao.ListarProducaoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.producao.NotificaConclusaoPedidoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.producao.SalvarProducaoAdapterPort;
import com.example.demo.core.usecase.impl.BuscarProducaoUseCase;
import com.example.demo.core.usecase.interfaces.producao.AlterarProducaoUseCasePort;
import com.example.demo.core.usecase.interfaces.producao.BuscarProducaoUseCasePort;
import com.example.demo.core.usecase.interfaces.producao.CriarProducaoUseCasePort;
import com.example.demo.core.usecase.interfaces.producao.ListarProducaoUseCasePort;
import com.example.demo.core.usecase.interfaces.producao.SalvarProducaoUseCasePort;
import com.example.demo.infrastructure.repository.ProducaoRepository;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BeanConfigTest {
    private BeanConfig beanConfig;

    @Mock
    private ListarProducaoAdapterPort listarProducaoAdapterPort;

    @Mock
    private SalvarProducaoAdapterPort salvarProducaoAdapterPort;

    @Mock
    private AtualizarProducaoAdapterPort atualizarProducaoAdapterPort;

    @Mock
    private ProducaoRepository producaoRepository;

    @Mock
    private AtualizarProducaoAdapter atualizarProducaoAdapter;

    @Mock
    private BuscarProducaoAdapter buscarProducaoAdapter;

    @Mock
    private NotificaConclusaoPedidoAdapterPort notificaConclusaoPedidoAdapterPort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        beanConfig = new BeanConfig();
    }

    @Test
    void testListarProducaoUseCasePort() {
        ListarProducaoUseCasePort useCase = beanConfig.listarProducaoUseCasePort(listarProducaoAdapterPort);
        assertNotNull(useCase);
    }

    @Test
    void testSalvarProducaoUseCasePort() {
        SalvarProducaoUseCasePort useCase = beanConfig.salvarProducaoUseCasePort(salvarProducaoAdapterPort);
        assertNotNull(useCase);
    }

    @Test
    void testAlterarProducaoUseCasePort() {
        BuscarProducaoUseCasePort buscarProducaoUseCasePort = new BuscarProducaoUseCase(producaoRepository);
        AlterarProducaoUseCasePort useCase = beanConfig.alterarProducaoUseCasePort(atualizarProducaoAdapterPort, buscarProducaoUseCasePort);
        assertNotNull(useCase);
    }

    @Test
    void testBuscarProducaoUseCasePort() {
        BuscarProducaoUseCasePort useCase = beanConfig.buscarProducaoUseCasePort(producaoRepository);
        assertNotNull(useCase);
    }

    @Test
    void testCriarProducaoUseCasePort() {
        CriarProducaoUseCasePort useCase = beanConfig.criarProducaoUseCasePort(
                atualizarProducaoAdapter,
                buscarProducaoAdapter,
                notificaConclusaoPedidoAdapterPort
        );
        assertNotNull(useCase);
    }
}