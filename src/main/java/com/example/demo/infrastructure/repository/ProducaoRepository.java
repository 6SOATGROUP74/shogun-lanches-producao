package com.example.demo.infrastructure.repository;

import com.example.demo.core.domain.Producao;
import com.example.demo.infrastructure.repository.entity.ProducaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducaoRepository extends JpaRepository<ProducaoEntity, Long> {

    Producao findByNumeroPedido(Long numeroPedido);

}
