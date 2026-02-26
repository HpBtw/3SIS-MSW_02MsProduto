package com.github.hpbtw.ms_produto.dto;

import com.github.hpbtw.ms_produto.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutoDto {
    private Long id;
    private String nome;
    private String descricao;
    private Double valor;

    public ProdutoDto(Produto p) {
        id = p.getId();
        nome = p.getNome();
        descricao = p.getDescricao();
        valor = p.getValor();
    }
}
