package com.example.demo.config;

import com.example.demo.adapter.gateway.interfaces.producao.AtualizarProducaoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.producao.ListarProducaoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.producao.SalvarProducaoAdapterPort;
import com.example.demo.core.usecase.impl.AlterarProducaoUseCase;
import com.example.demo.core.usecase.impl.BuscarProducaoUseCase;
import com.example.demo.core.usecase.impl.ListarProducaoUseCase;
import com.example.demo.core.usecase.impl.SalvarProducaoUseCase;
import com.example.demo.core.usecase.interfaces.producao.AlterarProducaoUseCasePort;
import com.example.demo.core.usecase.interfaces.producao.BuscarProducaoUseCasePort;
import com.example.demo.core.usecase.interfaces.producao.ListarProducaoUseCasePort;
import com.example.demo.core.usecase.interfaces.producao.SalvarProducaoUseCasePort;
import com.example.demo.infrastructure.repository.ProducaoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ListarProducaoUseCasePort listarProducaoUseCasePort(ListarProducaoAdapterPort listarProducaoAdapterPort) {
        return new ListarProducaoUseCase(listarProducaoAdapterPort);
    }

    @Bean
    public SalvarProducaoUseCasePort salvarProducaoUseCasePort(SalvarProducaoAdapterPort salvarProducaoAdapterPort) {
        return new SalvarProducaoUseCase(salvarProducaoAdapterPort);
    }

    @Bean
    public AlterarProducaoUseCasePort alterarProducaoUseCasePort(AtualizarProducaoAdapterPort atualizarProducaoAdapterPort, BuscarProducaoUseCasePort buscarProducaoUseCasePort){
        return new AlterarProducaoUseCase(atualizarProducaoAdapterPort, buscarProducaoUseCasePort);
    }

    @Bean
    public BuscarProducaoUseCasePort buscarProducaoUseCasePort(ProducaoRepository producaoRepository){
        return new BuscarProducaoUseCase(producaoRepository);
    }
}
