package com.example.demo.core.domain;

public class Producao {

    private Long idProducao;
    private String numeroPedido;
    private String etapa;
    private String dataCriacao;
    private String dataAtualizacao;

    public Long getIdProducao() {
        return idProducao;
    }

    public void setIdProducao(Long idProducao) {
        this.idProducao = idProducao;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "Producao{" +
                "idProducao=" + idProducao +
                ", numeroPedido='" + numeroPedido + '\'' +
                ", etapa='" + etapa + '\'' +
                ", dataCriacao='" + dataCriacao + '\'' +
                ", dataAtualizacao='" + dataAtualizacao + '\'' +
                '}';
    }
}