package com.example.demo.infrastructure.repository.presenter;

import com.example.demo.core.domain.Producao;
import com.example.demo.infrastructure.repository.entity.ProducaoEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Mapper
public interface ProducaoEntityMapper {

    ProducaoEntityMapper INSTANCE = Mappers.getMapper(ProducaoEntityMapper.class);

    @Mapping(target = "dataCriacao", expression = "java(dataHoraAtual())")
    @Mapping(target = "dataAtualizacao", expression = "java(dataHoraAtual())")
    ProducaoEntity mapFrom(Producao producao);

    Producao mapFrom(ProducaoEntity producaoEntity);

    List<Producao> mapFrom(List<ProducaoEntity> producaoEntity);

    ProducaoEntity updateFrom(Producao producao);

    default String dataHoraAtual() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @AfterMapping
    default ProducaoEntity afterMapping(@MappingTarget ProducaoEntity entity, Producao producao) {
        entity.setIdProducao(producao.getIdProducao());
        entity.setIdPagamento(producao.getIdPagamento());
        entity.setNumeroPedido(producao.getNumeroPedido());
        entity.setEtapa(producao.getEtapa());
        entity.setDataCriacao(producao.getDataCriacao());
        entity.setDataAtualizacao(producao.getDataAtualizacao());
        return entity;

    }

    Producao mapFrom(Optional<ProducaoEntity> producaoEntity);
}
