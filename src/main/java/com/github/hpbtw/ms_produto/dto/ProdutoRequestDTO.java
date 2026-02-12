package com.github.hpbtw.ms_produto.dto;

public class ProdutoRequestDTO { // input
    // não tem o ID pois é gerado como nulo, e retorna com os dados solicitados
    private String nome;
    private String descricao;
    private Double valor;

    public ProdutoRequestDTO() {}

    public ProdutoRequestDTO(String nome, String descricao, Double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
