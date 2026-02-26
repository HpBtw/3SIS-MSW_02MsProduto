package com.github.hpbtw.ms_produto.dto;

import com.github.hpbtw.ms_produto.entities.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutoDto {
    private Long id;

    @NotBlank(message = "Campo nome é requerido")
    @Size(min = 3, max = 100, message = "Nome deve conter entre 3 a 100 caracteres")
    private String nome;

    @NotBlank(message = "Campo descrição é requerido")
    @Size(min = 3, message = "Descrição deve conter pelo menos 3 caracteres")
    private String descricao;

    @NotBlank(message = "Campo valor é requerido")
    @Positive(message = "O valor deve ser maior que 0")
    private Double valor;

    public ProdutoDto(Produto p) {
        id = p.getId();
        nome = p.getNome();
        descricao = p.getDescricao();
        valor = p.getValor();
    }
}
