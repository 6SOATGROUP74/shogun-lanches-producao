package com.example.demo.adapter.presenter.producao;

import com.example.demo.adapter.controller.response.producao.ProducaoResponse;
import com.example.demo.core.domain.Producao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(uses = {Producao.class})
public interface ProducaoResponseMapper {

    ProducaoResponseMapper INSTANCE = Mappers.getMapper(ProducaoResponseMapper.class);

    ProducaoResponse mapFrom(Producao producao);

    List<ProducaoResponse> mapFrom(List<Producao> producaoList);
}
