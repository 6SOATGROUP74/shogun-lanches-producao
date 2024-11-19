package com.example.demo.adapter.controller.request.producao.mapper;

import com.example.demo.core.domain.Producao;
import com.example.demo.infrastructure.repository.entity.ProducaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProducaoMapper {

    ProducaoMapper INSTANCE = Mappers.getMapper(ProducaoMapper.class);

//    @Mapping(source = "idCliente", target = "cliente.idCliente")
//    @Mapping(source = "composicao", target = "composicao")
//    Pedido mapFrom(PedidoRequest pedidoRequest);
//
//    @Mapping(source = "numeroPedido", target = "numeroPedido")
//    Pedido mapFrom(AtualizaPedidoRequest atualizaPedidoRequest);

    List<ProducaoEntity> mapFrom(List<Producao> producaoList);

    ProducaoEntity mapFrom(Producao producao);

    Producao mapFrom(ProducaoEntity producaoEntity);

    List<Producao> mapfrom(List<ProducaoEntity> producaoEntityList);
}
