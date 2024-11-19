package com.example.demo.core.usecase.interfaces.producao;

import com.example.demo.core.domain.Producao;

public interface SalvarProducaoUseCasePort {
   Producao execute(Producao producao);
}