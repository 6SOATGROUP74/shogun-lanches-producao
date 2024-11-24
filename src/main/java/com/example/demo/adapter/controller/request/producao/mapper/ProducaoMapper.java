package com.example.demo.adapter.controller.request.producao.mapper;

import com.example.demo.core.domain.Producao;
import com.example.demo.infrastructure.repository.entity.ProducaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProducaoMapper {

    ProducaoMapper INSTANCE = Mappers.getMapper(ProducaoMapper.class);

    List<ProducaoEntity> mapFrom(List<Producao> producaoList);

    ProducaoEntity mapFrom(Producao producao);

    @Mapping(target = "idProducao", source = "producaoEntity.idProducao")
    @Mapping(target = "idPagamento", source = "producaoEntity.idPagamento")
    @Mapping(target = "numeroPedido", source = "producaoEntity.numeroPedido")
    @Mapping(target = "etapa", source = "producaoEntity.etapa")
    @Mapping(target = "dataCriacao", source = "producaoEntity.dataCriacao")
    @Mapping(target = "dataAtualizacao", source = "producaoEntity.dataAtualizacao")
    Producao mapFrom(ProducaoEntity producaoEntity);

    List<Producao> mapfrom(List<ProducaoEntity> producaoEntityList);
}
